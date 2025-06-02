package com.java.bytecupidsbackend.presentation.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class ModuleSaveRequest {
    private String moduleName;
    private List<String> prerequisites;
    private String targetAudience;
    private int estimatedTime;
    private String interpretation;
    private String agentNotes;
    private String difficultyLevel;
    private Timestamp lastUpdateTime;
    private String moduleId;
    private int noOfTopics;
    private int noOfSubTopics;
    private String organisation;
    private Boolean isDeleted;
    private String accessToken;

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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
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

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;

    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ModuleSaveRequest(String moduleName,String accessToken, List<String> prerequisites, String targetAudience, int estimatedTime, String interpretation, String agentNotes, String difficultyLevel, Timestamp lastUpdateTime, String moduleId, int noOfTopics, int noOfSubTopics, String organization, Boolean isDeleted) {
        this.moduleName = moduleName;
        this.prerequisites = prerequisites;
        this.targetAudience = targetAudience;
        this.estimatedTime = estimatedTime;
        this.interpretation = interpretation;
        this.agentNotes = agentNotes;
        this.difficultyLevel = difficultyLevel;
        this.lastUpdateTime = lastUpdateTime;
        this.moduleId = moduleId;
        this.noOfTopics = noOfTopics;
        this.noOfSubTopics = noOfSubTopics;
        this.organisation = organization;
        this.isDeleted = isDeleted;
        this.accessToken = accessToken;

    }
}
