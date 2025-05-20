package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="modules")
public class ModuleEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID module_id;

    private String moduleName;
    private String difficultyLevel;
    private int noOfTopics;
    private int noOfSubTopics;

    public ModuleEntity(UUID module_id, String moduleName, String difficultyLevel, int noOfTopics, int noOfSubTopics) {
        this.module_id = module_id;
        this.moduleName = moduleName;
        this.difficultyLevel = difficultyLevel;
        this.noOfTopics = noOfTopics;
        this.noOfSubTopics = noOfSubTopics;
    }

    public ModuleEntity() {

    }

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

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
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
