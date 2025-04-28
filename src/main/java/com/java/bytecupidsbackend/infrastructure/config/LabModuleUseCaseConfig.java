package com.java.bytecupidsbackend.infrastructure.config;

import com.java.bytecupidsbackend.application.usecase.LabModuleUseCase;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabModuleUseCaseConfig {

    @Bean
    public LabModuleUseCase labUseCase(ModuleRepository moduleRepository) {
        return new LabModuleUseCase(moduleRepository);
    }
}
