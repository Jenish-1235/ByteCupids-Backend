package com.java.bytecupidsbackend.infrastructure.config;

import com.java.bytecupidsbackend.application.usecase.LabUseCase;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabUseCaseConfig {

    @Bean
    public LabUseCase labUseCase(ModuleRepository moduleRepository) {
        return new LabUseCase(moduleRepository);
    }
}
