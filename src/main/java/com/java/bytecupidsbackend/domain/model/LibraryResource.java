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
}
