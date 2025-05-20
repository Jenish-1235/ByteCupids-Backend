package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;

public class Module {
    private UUID moduleId;
    private String name;
    private int noOfTopics;
    private int noOfSubTopics;
    private String difficultyLevel;

    public Module(UUID moduleId, String name, int noOfTopics, int noOfSubTopics,String difficultyLevel) {
        this.moduleId = moduleId;
        this.name = name;
        this.noOfTopics = noOfTopics;
        this.noOfSubTopics = noOfSubTopics;
        this.difficultyLevel = difficultyLevel;
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

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
