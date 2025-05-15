package com.java.bytecupidsbackend.agents;

import com.java.bytecupidsbackend.agentorchestration.AgentService;
import com.java.bytecupidsbackend.promptdirectory.ModuleInputFormatterPromptProvider;
import com.java.bytecupidsbackend.services.AzureOpenAIService;
import reactor.core.publisher.Flux;

public class ModuleInputFormatter implements AgentService {

    private final AzureOpenAIService azureOpenAIService;

    public ModuleInputFormatter(AzureOpenAIService azureOpenAIService) {
        this.azureOpenAIService = azureOpenAIService;
    }

    @Override
    public Flux<String> getStreamResponse(String prompt, String agentKey) {
        return azureOpenAIService.chatStream(agentKey, ModuleInputFormatterPromptProvider.getPrompt() ,prompt, 0.3);
    }

    @Override
    public String getResponse(String prompt, String agentKey){
        return azureOpenAIService.getResponse(agentKey, ModuleInputFormatterPromptProvider.getPrompt() ,prompt, 0.3);
    }
}
