package com.java.bytecupidsbackend.application.usecase.admin;

import com.java.bytecupidsbackend.application.agents.Manager;
import com.java.bytecupidsbackend.presentation.dto.admin.AdminCreateModuleResponse;
import org.hibernate.engine.spi.Managed;

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
