package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;

public class Module {
    private UUID moduleId;
    private String name;
    private String moduleImgUri;
    private int noOfTopics;

    public Module(UUID moduleId, String name, String moduleImgUri, int noOfTopics) {
        this.moduleId = moduleId;
        this.name = name;
        this.moduleImgUri = moduleImgUri;
        this.noOfTopics = noOfTopics;
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

    public String getModuleImgUri() {
        return moduleImgUri;
    }

    public void setModuleImgUri(String moduleImgUri) {
        this.moduleImgUri = moduleImgUri;
    }

    public int getNoOfTopics() {
        return noOfTopics;
    }

    public void setNoOfTopics(int noOfTopics) {
        this.noOfTopics = noOfTopics;
    }
}
