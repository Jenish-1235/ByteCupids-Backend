package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "subtopics")
public class SubTopicEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID subTopicId;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private ModuleEntity moduleEntity;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private TopicEntity topicEntity;

    @Column(nullable = false)
    private String subTopicName;

    @Column(nullable = false)
    private int sequenceNumber;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    public SubTopicEntity() {}

    public SubTopicEntity(UUID subTopicId, ModuleEntity moduleEntity, TopicEntity topicEntity, String subTopicName, int sequenceNumber,Boolean isDeleted) {
        this.subTopicId = subTopicId;
        this.moduleEntity = moduleEntity;
        this.topicEntity = topicEntity;
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

    public UUID getSubTopicId() {
        return subTopicId;
    }

    public void setSubTopicId(UUID subTopicId) {
        this.subTopicId = subTopicId;
    }

    public ModuleEntity getModuleEntity() {
        return moduleEntity;
    }

    public void setModuleEntity(ModuleEntity moduleEntity) {
        this.moduleEntity = moduleEntity;
    }

    public TopicEntity getTopicEntity() {
        return topicEntity;
    }

    public void setTopicEntity(TopicEntity topicEntity) {
        this.topicEntity = topicEntity;
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