package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "topics")
public class SubTopicEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID subTopicId;

    @Column(nullable = false)
    private UUID moduleId;
    private String topicName;
    private String subTopicName;

    public SubTopicEntity(UUID subTopicId, UUID moduleId, String topicName, String subTopicName) {
        this.subTopicId = subTopicId;
        this.moduleId = moduleId;
        this.topicName = topicName;
        this.subTopicName = subTopicName;
    }

    public SubTopicEntity() {

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

    public UUID getSubTopicId() {
        return subTopicId;
    }

    public void setSubTopicId(UUID subTopicId) {
        this.subTopicId = subTopicId;
    }

    public String getSubTopicName() {
        return subTopicName;
    }

    public void setSubTopicName(String subTopicName) {
        this.subTopicName = subTopicName;
    }
}
