package com.java.bytecupidsbackend.domain.repository;

import com.java.bytecupidsbackend.domain.model.SubTopic;

import java.util.List;

public interface SubTopicRepository {
    List<SubTopic> getAllSubTopics(String moduleId);
}
