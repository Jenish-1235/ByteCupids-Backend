package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;

public class SubTopic {
    private UUID subTopicId;
    private UUID moduleId;
    private UUID topicId;
    private String subTopicName;
    private int sequenceNumber;
    private Boolean isDeleted;

    public SubTopic(UUID subTopicId, UUID moduleId, UUID topicId, String subTopicName, int sequenceNumber,Boolean isDeleted) {
        this.subTopicId = subTopicId;
        this.moduleId = moduleId;
        this.topicId = topicId;
        this.subTopicName = subTopicName;
        this.sequenceNumber = sequenceNumber;
        this.isDeleted = isDeleted;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public SubTopic() {}

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

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public String getSubTopicName() {
        return subTopicName;
    }

    public void setSubTopicName(String subTopicName) {
        this.subTopicName = subTopicName;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}