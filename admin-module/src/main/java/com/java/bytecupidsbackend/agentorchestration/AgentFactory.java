package com.java.bytecupidsbackend.agentorchestration;

import com.java.bytecupidsbackend.agents.ModuleInputFormatter;
import com.java.bytecupidsbackend.services.AzureOpenAIService;
import org.springframework.stereotype.Component;

@Component
public class AgentFactory {

    private final AzureOpenAIService service;

    public AgentFactory(AzureOpenAIService service) {
        this.service = service;
    }

    public AgentService getAgent(String model){

        switch (model) {
            case "MODULE_INPUT_FORMATTER":
                return new ModuleInputFormatter(service);
            default:
                return new GeminiFallbackService();
        }
    }
}
