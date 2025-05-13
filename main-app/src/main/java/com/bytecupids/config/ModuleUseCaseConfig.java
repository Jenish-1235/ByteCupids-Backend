package com.bytecupids.config;

import com.java.bytecupidsbackend.application.usecase.ModuleUseCase;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ModuleUseCaseConfig {

    @Bean
    public ModuleUseCase labUseCase(ModuleRepository moduleRepository) {
        return new ModuleUseCase(moduleRepository);
    }
}
