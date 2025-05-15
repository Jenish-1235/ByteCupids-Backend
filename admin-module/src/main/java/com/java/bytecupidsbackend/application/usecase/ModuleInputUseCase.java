package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.presentation.dto.ModuleInputResponse;
import com.java.bytecupidsbackend.promptdirectory.ModuleInputFormatterPromptProvider;

public class ModuleInputUseCase {
    private final Manager manager;
    public ModuleInputUseCase(Manager manager) {
        this.manager = manager;
    }
    private String agentKey = "module-input-formatter";
    public ModuleInputResponse execute(String moduleName, String moduleMetadata) {
        String prompt = ModuleInputFormatterPromptProvider.getPrompt(moduleName, moduleMetadata);
        String response = manager.execute(prompt, agentKey);
        ModuleInputResponse moduleInputResponse = new ModuleInputResponse();
        moduleInputResponse.setMessage(response);
        return moduleInputResponse;

    }
}
