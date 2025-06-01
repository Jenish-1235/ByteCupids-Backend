package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "modules")
public class ModuleEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID moduleId;

    @Column(nullable = false)
    private String moduleName;

    @Column(nullable = false)
    private int noOfTopics;

    @Column(nullable = false)
    private int noOfSubTopics;

    @ElementCollection
    @CollectionTable(name = "module_prerequisites", joinColumns = @JoinColumn(name = "module_id"))
    @Column(name = "prerequisite")
    private List<String> prerequisites;

    @Column(nullable = false)
    private String targetAudience;

    @Column(nullable = false)
    private int estimatedTime;

    @Column(nullable = false)
    private String interpretation;

    @Column(nullable = false)
    private String agentNotes;

    @Column(nullable = false)
    private String difficultyLevel;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    private OrganisationEntity organization;

    private Timestamp lastUpdateTime;

    public ModuleEntity() {}

    public ModuleEntity(UUID moduleId, String moduleName, int noOfTopics, int noOfSubTopics, List<String> prerequisites, String targetAudience, int estimatedTime, String interpretation, String agentNotes, String difficultyLevel, Timestamp lastUpdateTime) {
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
    }

    public UUID getModuleId() {
        return moduleId;
    }

    public void setModuleId(UUID moduleId) {
        this.moduleId = moduleId;
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

    public OrganisationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganisationEntity organization) {
        this.organization = organization;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}