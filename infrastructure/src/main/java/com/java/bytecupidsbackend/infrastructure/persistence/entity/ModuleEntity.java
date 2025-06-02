package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="modules")
public class ModuleEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID module_id;

    private String moduleName;
    private int noOfTopics;
    private int noOfSubTopics;
    private String difficultyLevel;
    private int estimatedTime;
    private String agentNotes;
    private String interpretation;
    private UUID organizationId;
    private LocalDateTime lastUpdatedTime;
    private String targetAudience;
    private byte[] prerequisites;


    public ModuleEntity(UUID module_id, String moduleName, int noOfTopics, int noOfSubTopics, String difficultyLevel, int estimatedTime, String agentNotes, String interpretation, UUID organizationId, LocalDateTime lastUpdatedTime, String targetAudience, byte[] prerequisites) {
        this.module_id = module_id;
        this.moduleName = moduleName;
        this.noOfTopics = noOfTopics;
        this.noOfSubTopics = noOfSubTopics;
        this.difficultyLevel = difficultyLevel;
        this.estimatedTime = estimatedTime;
        this.agentNotes = agentNotes;
        this.interpretation = interpretation;
        this.organizationId = organizationId;
        this.lastUpdatedTime = lastUpdatedTime;
        this.targetAudience = targetAudience;
        this.prerequisites = prerequisites;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getAgentNotes() {
        return agentNotes;
    }

    public void setAgentNotes(String agentNotes) {
        this.agentNotes = agentNotes;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public byte[] getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(byte[] prerequisites) {
        this.prerequisites = prerequisites;
    }

    public ModuleEntity() {}

    public UUID getModule_id() {
        return module_id;
    }

    public void setModule_id(UUID module_id) {
        this.module_id = module_id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getNoOfTopics() {
        return noOfTopics;
    }

    public void setNoOfTopics(int noOfTopics) {
        this.noOfTopics = noOfTopics;
    }

    public int getNoOfSubTopics() {
        return noOfSubTopics;
    }
    public void setNoOfSubTopics(int noOfSubTopics) {
        this.noOfSubTopics = noOfSubTopics;
    }
}
