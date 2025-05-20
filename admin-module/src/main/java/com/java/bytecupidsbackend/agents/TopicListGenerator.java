package com.java.bytecupidsbackend.agents;

import com.java.bytecupidsbackend.agentorchestration.AgentService;
import com.java.bytecupidsbackend.promptdirectory.TopicListGeneratorPromptProvider;
import com.java.bytecupidsbackend.services.AzureOpenAIService;
import reactor.core.publisher.Flux;

public class TopicListGenerator implements AgentService {

    private final AzureOpenAIService azureOpenAIService;

    public TopicListGenerator(AzureOpenAIService azureOpenAIService) {
        this.azureOpenAIService = azureOpenAIService;
    }

    @Override
    public Flux<String> getStreamResponse(String prompt, String agentKey) {
        return azureOpenAIService.chatStream(agentKey, TopicListGeneratorPromptProvider.getPrompt() ,prompt, 0.3);
    }

    @Override
    public String getResponse(String prompt, String agentKey) {
        return azureOpenAIService.getResponse(agentKey, TopicListGeneratorPromptProvider.getPrompt() ,prompt, 0.3);
    }
}
