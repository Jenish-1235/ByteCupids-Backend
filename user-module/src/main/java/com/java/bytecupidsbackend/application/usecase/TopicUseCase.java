package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.Topic;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import com.java.bytecupidsbackend.presentation.dto.TopicsResponse;

import java.util.List;

public class TopicUseCase {
    private final TopicRepository topicRepository;

    public TopicUseCase(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public TopicsResponse getAllTopics(String moduleId) {
        TopicsResponse response = new TopicsResponse();
        List<Topic> topics = topicRepository.getAllTopics(moduleId);
        response.setTopics(topics);
        response.setTimestamp(String.valueOf(System.currentTimeMillis()));

        if(!topics.isEmpty()) {
            response.setSuccess(true);
            response.setMessage("Found " + topics.size() + " topics");
            response.setCode(200);
        }else {
            response.setSuccess(false);
            response.setMessage("No topics found");
            response.setCode(404);
        }
        return response;
    }
}
