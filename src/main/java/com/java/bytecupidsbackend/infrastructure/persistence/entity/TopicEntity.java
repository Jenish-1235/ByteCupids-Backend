package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "topics")
public class TopicEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID topicId;

    @Column(nullable = false)
    private UUID moduleId;
    private String topicName;
    private int noOfLabs;

    public TopicEntity(UUID topicId, UUID moduleId, String topicName, int noOfLabs) {
        this.topicId = topicId;
        this.moduleId = moduleId;
        this.topicName = topicName;
        this.noOfLabs = noOfLabs;
    }

    public TopicEntity() {

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
