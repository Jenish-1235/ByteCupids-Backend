package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.Topic;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import com.java.bytecupidsbackend.presentation.dto.LabTopicsResponse;

import java.util.List;

public class LabTopicUseCase {

    private final TopicRepository topicRepository;
    public LabTopicUseCase(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public LabTopicsResponse getAllTopics(String moduleId) {
        LabTopicsResponse response = new LabTopicsResponse();
        List<Topic> topics = topicRepository.getAllTopics(moduleId);
        response.setTopics(topics);
        response.setTimestamp(String.valueOf(System.currentTimeMillis()));

        if (!topics.isEmpty()) {
            response.setMessage("Found " + topics.size() + " topics");
            response.setSuccess(true);
            response.setCode(200);
            response.setStatus("SUCCESS");
        }else{
            response.setMessage("No topics found");
            response.setSuccess(false);
            response.setCode(404);
            response.setStatus("ERROR");
            response.setMessage("No topics found");
        }
        return response;
    }
}
