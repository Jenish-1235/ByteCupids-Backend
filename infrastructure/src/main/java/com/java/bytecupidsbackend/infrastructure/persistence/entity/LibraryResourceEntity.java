package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "library_resources")
public class LibraryResourceEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "resource_id")
    private UUID resourceId;

    private UUID moduleId;
    private String resourceName;
    private String resourceType;
    private String resourceUri;
    private Boolean isDeleted;

    public LibraryResourceEntity() {}

    public LibraryResourceEntity(UUID resourceId, UUID moduleId, String resourceName, String resourceType, String resourceUri,Boolean isDeleted) {
        this.resourceId = resourceId;
        this.moduleId = moduleId;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.resourceUri = resourceUri;
        this.isDeleted = isDeleted;
    }

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
