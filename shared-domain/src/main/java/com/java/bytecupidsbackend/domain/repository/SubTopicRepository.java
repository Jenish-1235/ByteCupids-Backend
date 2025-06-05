package com.java.bytecupidsbackend.domain.repository;

import com.java.bytecupidsbackend.domain.model.SubTopic;
import com.java.bytecupidsbackend.domain.model.Topic;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubTopicRepository {
    List<SubTopic> getAllSubTopics(String moduleId);
    Optional<SubTopic> findBySubTopicId(UUID subtopicId);

    void saveSubTopic(SubTopic subtopic);
}
