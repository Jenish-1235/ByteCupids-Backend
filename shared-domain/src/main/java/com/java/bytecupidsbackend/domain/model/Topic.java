package com.java.bytecupidsbackend.domain.model;
import java.util.UUID;

public class Topic {
    private UUID topicId;
    private String topicName;
    private UUID moduleId;
    private Boolean isDeleted;


    public Topic(UUID topicId, String topicName, UUID moduleId,Boolean isDeleted) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.moduleId = moduleId;
        this.isDeleted = isDeleted;
    }

    public Topic() {}

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

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
