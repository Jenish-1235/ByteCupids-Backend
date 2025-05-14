package com.bytecupids.config.admin;

import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.application.usecase.ModuleInputUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AdminModuleUseCaseConfig {

    @Bean
    public ModuleInputUseCase getAdminModuleUseCase(Manager manager) {
        return new ModuleInputUseCase(manager);
    }
}
