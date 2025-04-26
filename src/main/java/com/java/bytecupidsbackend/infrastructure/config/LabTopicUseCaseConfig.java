package com.java.bytecupidsbackend.infrastructure.config;

import com.java.bytecupidsbackend.application.usecase.LabTopicUseCase;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabTopicUseCaseConfig {


    @Bean
    public LabTopicUseCase labTopicUseCase(TopicRepository topicRepository) {
        return new LabTopicUseCase(topicRepository);
    }
}
