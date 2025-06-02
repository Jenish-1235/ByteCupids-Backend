package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;
import java.time.LocalDateTime;

public class Module {
    private UUID moduleId;
    private String name;
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

    public Module(UUID moduleId, String name, int noOfTopics, int noOfSubTopics, String difficultyLevel, int estimatedTime, String agentNotes, String interpretation, UUID organizationId, LocalDateTime lastUpdatedTime, String targetAudience, byte[] prerequisites) {
        this.moduleId = moduleId;
        this.name = name;
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

    public UUID getModuleId() {
        return moduleId;
    }

    public void setModuleId(UUID moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
