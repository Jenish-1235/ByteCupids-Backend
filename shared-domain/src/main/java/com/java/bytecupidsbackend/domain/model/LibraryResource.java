package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;

public class LibraryResource {

    private UUID resourceId;
    private UUID moduleId;
    private String resourceName;
    private String resourceType;
    private String resourceUri;

    public LibraryResource(UUID resourceId, UUID moduleId, String resourceName, String resourceType, String resourceUri) {
        this.resourceId = resourceId;
        this.moduleId = moduleId;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.resourceUri = resourceUri;
    }

    public LibraryResource() {}

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    public UUID getModuleId() {
        return moduleId;
    }

    public void setModuleId(UUID moduleId) {
        this.moduleId = moduleId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }
}
