package com.java.bytecupidsbackend.infrastructure.config.admin;

import com.java.bytecupidsbackend.application.agents.Manager;
import com.java.bytecupidsbackend.application.usecase.admin.AdminModuleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AdminModuleUseCaseConfig {

    @Bean
    public AdminModuleUseCase getAdminModuleUseCase(Manager manager) {
        return new AdminModuleUseCase(manager);
    }
}
