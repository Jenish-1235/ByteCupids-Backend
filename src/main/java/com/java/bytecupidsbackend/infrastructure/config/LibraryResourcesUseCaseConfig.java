package com.java.bytecupidsbackend.infrastructure.config;

import com.java.bytecupidsbackend.application.usecase.LibraryResourcesUseCase;
import com.java.bytecupidsbackend.domain.repository.LibraryResourceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class LibraryResourcesUseCaseConfig {

    @Bean
    public LibraryResourcesUseCase libraryResourcesUseCase(LibraryResourceRepository libraryResourceRepository) {
        return new LibraryResourcesUseCase(libraryResourceRepository);
    }
}
