package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.presentation.dto.AdminCreateModuleRequest;
import com.java.bytecupidsbackend.presentation.dto.AdminCreateModuleResponse;

public class AdminModuleUseCase {
    private final Manager manager;
    public AdminModuleUseCase(Manager manager) {
        this.manager = manager;
    }
    private String model = "USER_INPUT_AGENT";
    public AdminCreateModuleResponse execute(String moduleName, String moduleMetadata) {
        String prompt = "Module Name: " + moduleName + "\nMetadata: " + moduleMetadata;
        String response = manager.execute(prompt, model);
        return new AdminCreateModuleResponse();
    }
}
