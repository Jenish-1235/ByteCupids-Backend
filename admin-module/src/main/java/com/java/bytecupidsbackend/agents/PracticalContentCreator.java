package com.java.bytecupidsbackend.agents;

import com.java.bytecupidsbackend.agentorchestration.AgentService;
import com.java.bytecupidsbackend.services.AzureOpenAIService;
import reactor.core.publisher.Flux;

public class PracticalContentCreator implements AgentService {

    private final AzureOpenAIService azureOpenAIService;

    public PracticalContentCreator(AzureOpenAIService azureOpenAIService) {
        this.azureOpenAIService = azureOpenAIService;
    }


    @Override
    public Flux<String> getStreamResponse(String prompt, String agentKey) {
        return null;
    }

    @Override
    public String getResponse(String prompt, String agentKey) {
        return "";
    }
}
