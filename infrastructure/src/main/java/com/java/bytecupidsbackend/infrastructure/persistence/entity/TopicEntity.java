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

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    public TopicEntity() {}

    public TopicEntity(UUID topicId, ModuleEntity moduleEntity, String topicName, Boolean isDeleted) {
        this.topicId = topicId;
        this.moduleEntity = moduleEntity;
        this.topicName = topicName;
        this.isDeleted = isDeleted;
    }

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