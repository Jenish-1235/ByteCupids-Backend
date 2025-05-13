package com.java.bytecupidsbackend.infrastructure.config;

import com.java.bytecupidsbackend.application.usecase.TopicUseCase;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicUseCaseConfig {


    @Bean
    public TopicUseCase labTopicUseCase(TopicRepository topicRepository) {
        return new TopicUseCase(topicRepository);
    }
}
