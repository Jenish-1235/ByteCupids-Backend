package com.java.bytecupidsbackend.agents;

import com.java.bytecupidsbackend.agentorchestration.AgentService;
import com.java.bytecupidsbackend.services.AzureOpenAIService;

public class ModuleInputFormatter implements AgentService {

    private final AzureOpenAIService azureOpenAIService;

    public ModuleInputFormatter(AzureOpenAIService azureOpenAIService) {
        this.azureOpenAIService = azureOpenAIService;
    }

    @Override
    public String getResponse(String prompt) {
        return azureOpenAIService.chat("module-input-formatter", "Hello", "Hello", 0.3);
    }

}
