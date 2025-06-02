package com.java.bytecupidsbackend.domain.model;
import java.util.UUID;

public class Topic {
    private UUID topicId;
    private String topicName;
    private UUID moduleId;


    public Topic(UUID topicId, String topicName, UUID moduleId) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.moduleId = moduleId;
    }

    public Topic() {}


    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public UUID getModuleId() {
        return moduleId;
    }

    public void setModuleId(UUID moduleId) {
        this.moduleId = moduleId;
    }
}
