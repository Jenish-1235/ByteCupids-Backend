package com.bytecupids.config;

import com.java.bytecupidsbackend.application.usecase.SubTopicUseCase;
import com.java.bytecupidsbackend.domain.repository.SubTopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubTopicUseCaseConfig {


    @Bean
    public SubTopicUseCase labSubTopicUseCase(SubTopicRepository subtopicRepository) {
        return new SubTopicUseCase(subtopicRepository);
    }
}
