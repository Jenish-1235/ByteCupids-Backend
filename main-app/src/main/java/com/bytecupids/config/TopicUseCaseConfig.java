package com.bytecupids.config;

import com.java.bytecupidsbackend.application.usecase.TopicUseCase;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class TopicUseCaseConfig {


    @Bean
    public TopicUseCase labTopicUseCase(TopicRepository topicRepository) {
        return new TopicUseCase(topicRepository);
    }
}
