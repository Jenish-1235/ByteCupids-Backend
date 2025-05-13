package com.java.bytecupidsbackend.domain.repository;

import com.java.bytecupidsbackend.domain.model.SubTopic;

import java.util.List;

public interface TopicRepository {
    List<SubTopic> getAllTopics(String moduleId);
}
