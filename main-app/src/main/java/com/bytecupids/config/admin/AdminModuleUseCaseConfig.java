package com.bytecupids.config.admin;

import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.application.usecase.AdminModuleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AdminModuleUseCaseConfig {

    @Bean
    public AdminModuleUseCase getAdminModuleUseCase(Manager manager) {
        return new AdminModuleUseCase(manager);
    }
}
