package com.java.bytecupidsbackend.services;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.implementation.accesshelpers.ChatCompletionsOptionsAccessHelper;
import com.azure.ai.openai.models.*;
import com.azure.core.credential.AzureKeyCredential;
import com.java.bytecupidsbackend.configs.AzureOpenAIProperties;
import com.java.bytecupidsbackend.configs.GCPSecretsManager;
import com.java.bytecupidsbackend.promptdirectory.ModuleInputFormatterPromptProvider;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AzureOpenAIService {

    private final Map<String, AzureOpenAIProperties.AgentConfig> agentConfigs;
    private final GCPSecretsManager secretManager;

    public AzureOpenAIService(AzureOpenAIProperties properties, GCPSecretsManager secretManager) {
        this.agentConfigs = properties.getAgents();
        this.secretManager = secretManager;
    }

    public Flux<String> chatStream(String agentKey, String userPrompt, double temperature) {
        AzureOpenAIProperties.AgentConfig config = agentConfigs.get(agentKey);

        if (config == null) {
            throw new IllegalArgumentException("No OpenAI config found for agent: " + agentKey);
        }

        String apiKey = secretManager.getSecret("bytecupids", "AZURE_OPENAI_KEY").trim();
        OpenAIAsyncClient client = new OpenAIClientBuilder()
                .endpoint(config.getEndPoint())
                .credential(new AzureKeyCredential(apiKey))
                .buildAsyncClient();

        List<ChatRequestMessage> messages = List.of(
                new ChatRequestSystemMessage(ModuleInputFormatterPromptProvider.getPrompt()),
                new ChatRequestUserMessage(userPrompt)
        );

        ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
                .setMaxTokens(1024)
                .setTemperature(temperature)
                .setTopP(0.9);

        ChatCompletionsOptionsAccessHelper.setStream(options, true);
        return Flux.from(client.getChatCompletionsStream(config.getDeploymentId(), options)).map(
                        response -> {
                            if (response.getChoices() == null || response.getChoices().isEmpty()) {
                                return "";
                            }
                            String token = String.valueOf(response.getChoices().get(0).getDelta().getContent());
                            System.out.println("🔁 Token: " + token);
                            return token;
                })
                .filter(token -> token != null && !token.isBlank());
    }

}
