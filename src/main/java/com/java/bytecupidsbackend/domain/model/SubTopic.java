package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;

public class SubTopic {
    private UUID subTopicId;
    private UUID moduleId;
    private String topicName;
    private String subTopicName;

    public SubTopic(UUID subTopicId, UUID moduleId, String topicName, String subTopicName) {
        this.subTopicId = subTopicId;
        this.moduleId = moduleId;
        this.topicName = topicName;
        this.subTopicName = subTopicName;
    }

    public UUID getSubTopicId() {
        return subTopicId;
    }

    public void setSubTopicId(UUID subTopicId) {
        this.subTopicId = subTopicId;
    }

    public UUID getModuleId() {
        return moduleId;
    }

    public void setModuleId(UUID moduleId) {
        this.moduleId = moduleId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getSubTopicName() {
        return subTopicName;
    }

    public void setSubTopicName(String subTopicName) {
        this.subTopicName = subTopicName;
    }
}
