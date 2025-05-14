package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.presentation.dto.ModuleInputResponse;

public class ModuleInputUseCase {
    private final Manager manager;
    public ModuleInputUseCase(Manager manager) {
        this.manager = manager;
    }
    private String model = "USER_INPUT_AGENT";
    public ModuleInputResponse execute(String moduleName, String moduleMetadata) {
        String prompt = "Module Name: " + moduleName + "\nMetadata: " + moduleMetadata;
        String response = manager.execute(prompt, model);
        return new ModuleInputResponse();
    }
}
