package com.java.bytecupidsbackend.services;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.*;
import com.azure.core.credential.AzureKeyCredential;
import com.java.bytecupidsbackend.configs.AzureOpenAIProperties;
import com.java.bytecupidsbackend.configs.GCPSecretsManager;
import org.springframework.stereotype.Component;

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

    public String chat(String agentKey, String userPrompt, double temperature) {
        AzureOpenAIProperties.AgentConfig config = agentConfigs.get(agentKey);

        if (config == null) {
            throw new IllegalArgumentException("No OpenAI config found for agent: " + agentKey);
        }

        String apiKey = secretManager.getSecret("bytecupids", "AZURE_OPENAI_KEY").trim();
        OpenAIClient client = new OpenAIClientBuilder()
                .endpoint(config.getEndPoint())
                .credential(new AzureKeyCredential(apiKey))
                .buildClient();

        String systemPrompt = config.getSystemPrompt();
        List<ChatRequestMessage> messages = List.of(
                new ChatRequestSystemMessage(systemPrompt),
                new ChatRequestUserMessage(userPrompt)
        );

        ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
                .setMaxTokens(1024)
                .setTemperature(temperature)
                .setTopP(0.9);

        ChatCompletions response = client.getChatCompletions(config.getDeploymentId(), options);
        return response.getChoices().get(0).getMessage().getContent();
    }
}
