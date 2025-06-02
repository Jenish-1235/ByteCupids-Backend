package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.SubTopic;
import com.java.bytecupidsbackend.domain.repository.SubTopicRepository;
import com.java.bytecupidsbackend.presentation.dto.SubTopicsResponse;

import java.util.List;

public class SubTopicUseCase {

    private final SubTopicRepository subtopicRepository;
    public SubTopicUseCase(SubTopicRepository subtopicRepository) {
        this.subtopicRepository = subtopicRepository;
    }

    public SubTopicsResponse getAllSubTopics(String moduleId) {
        SubTopicsResponse response = new SubTopicsResponse();
        List<SubTopic> subtopics = subtopicRepository.getAllSubTopics(moduleId);
        response.setSubTopics(subtopics);
        response.setTimestamp(String.valueOf(System.currentTimeMillis()));

        if (!subtopics.isEmpty()) {
            response.setMessage("Found " + subtopics.size() + " subtopics");
            response.setSuccess(true);
            response.setCode(200);
        }else{
            response.setMessage("No subtopics found");
            response.setSuccess(false);
            response.setCode(404);
        }
        return response;
    }
}
