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
    private String moduleImgUri;
    private int noOfTopics;

    public ModuleEntity(String moduleName, String moduleImgUri, int noOfTopics){
        this.moduleName = moduleName;
        this.moduleImgUri = moduleImgUri;
        this.noOfTopics = noOfTopics;
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
