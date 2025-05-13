package com.java.bytecupidsbackend.infrastructure.config;

import com.java.bytecupidsbackend.application.usecase.ModuleUseCase;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleUseCaseConfig {

    @Bean
    public ModuleUseCase labUseCase(ModuleRepository moduleRepository) {
        return new ModuleUseCase(moduleRepository);
    }
}
