package com.java.bytecupidsbackend.agents;

import com.java.bytecupidsbackend.agentorchestration.AgentService;
import com.java.bytecupidsbackend.services.AzureOpenAIService;
import reactor.core.publisher.Flux;

public class ModuleInputFormatter implements AgentService {

    private final AzureOpenAIService azureOpenAIService;

    public ModuleInputFormatter(AzureOpenAIService azureOpenAIService) {
        this.azureOpenAIService = azureOpenAIService;
    }

    @Override
    public Flux<String> getResponse(String prompt, String agentKey) {
        return azureOpenAIService.chatStream(agentKey, prompt, 0.3);
    }

}
