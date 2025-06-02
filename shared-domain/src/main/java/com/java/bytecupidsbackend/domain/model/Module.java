package com.java.bytecupidsbackend.domain.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class Module {
    private String moduleName;
    private List<String> prerequisites;
    private String targetAudience;
    private int estimatedTime;
    private String interpretation;
    private String agentNotes;
    private String difficultyLevel;
    private Timestamp lastUpdateTime;
    private UUID moduleId;
    private int noOfTopics;
    private int noOfSubTopics;
    private UUID organization;

    public UUID getOrganization() {
        return organization;
    }

    public void setOrganization(UUID organization) {
        this.organization = organization;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public String getAgentNotes() {
        return agentNotes;
    }

    public void setAgentNotes(String agentNotes) {
        this.agentNotes = agentNotes;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    public Module(UUID moduleId, String moduleName, int noOfTopics, int noOfSubTopics, List<String> prerequisites, String targetAudience, int estimatedTime, String interpretation, String agentNotes, String difficultyLevel, Timestamp lastUpdateTime,UUID organization) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.noOfTopics = noOfTopics;
        this.noOfSubTopics = noOfSubTopics;
        this.prerequisites = prerequisites;
        this.targetAudience = targetAudience;
        this.estimatedTime = estimatedTime;
        this.interpretation = interpretation;
        this.agentNotes = agentNotes;
        this.difficultyLevel = difficultyLevel;
        this.lastUpdateTime = lastUpdateTime;
        this.organization = organization;
    }


    public UUID getModuleId() {
        return moduleId;
    }

    public void setModuleId(UUID moduleId) {
        this.moduleId = moduleId;
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
