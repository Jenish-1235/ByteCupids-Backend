package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "topics")
public class TopicEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID topicId;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private ModuleEntity moduleEntity;

    @Column(nullable = false)
    private String topicName;

    public TopicEntity() {}

    public TopicEntity(UUID topicId, ModuleEntity moduleEntity, String topicName) {
        this.topicId = topicId;
        this.moduleEntity = moduleEntity;
        this.topicName = topicName;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public ModuleEntity getModuleEntity() {
        return moduleEntity;
    }

    public void setModuleEntity(ModuleEntity moduleEntity) {
        this.moduleEntity = moduleEntity;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}