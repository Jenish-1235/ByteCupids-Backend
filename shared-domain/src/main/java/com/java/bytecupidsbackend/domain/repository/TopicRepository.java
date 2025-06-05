package com.java.bytecupidsbackend.domain.repository;

import com.java.bytecupidsbackend.domain.model.Topic;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TopicRepository {
    List<Topic> getAllTopics(String moduleId);

    Optional<Topic> findByTopicId(UUID topicId);

    void saveTopic(Topic topic);
}
