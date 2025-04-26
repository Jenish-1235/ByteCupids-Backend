package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;

public class Topic {
    private UUID topicId;
    private UUID moduleId;
    private String topicName;
    private int noOfLabs;

    public Topic(UUID topicId, UUID moduleId, String topicName, int noOfLabs) {
        this.topicId = topicId;
        this.moduleId = moduleId;
        this.topicName = topicName;
        this.noOfLabs = noOfLabs;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
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

    public int getNoOfLabs() {
        return noOfLabs;
    }

    public void setNoOfLabs(int noOfLabs) {
        this.noOfLabs = noOfLabs;
    }
}
