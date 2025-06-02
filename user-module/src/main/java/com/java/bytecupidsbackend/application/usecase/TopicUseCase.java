package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.SubTopic;
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
        List<SubTopic> topics = topicRepository.getAllTopics(moduleId);
        response.setTopics(topics);
        response.setTimestamp(String.valueOf(System.currentTimeMillis()));

        if (!topics.isEmpty()) {
            response.setMessage("Found " + topics.size() + " topics");
            response.setSuccess(true);
            response.setCode(200);
        }else{
            response.setMessage("No topics found");
            response.setSuccess(false);
            response.setCode(404);
        }
        return response;
    }
}
