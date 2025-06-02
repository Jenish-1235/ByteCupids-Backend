package com.java.bytecupidsbackend.domain.repository;

import com.java.bytecupidsbackend.domain.model.Topic;

import java.util.List;

public interface TopicRepository {
    List<Topic> getAllTopics(String moduleId);
}
