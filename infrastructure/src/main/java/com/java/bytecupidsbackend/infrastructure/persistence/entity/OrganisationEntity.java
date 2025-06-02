package com.java.bytecupidsbackend.infrastructure.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "organisations")
public class OrganisationEntity {

    @Id
    @GeneratedValue(generator= "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID organisationId;

    @Column(nullable = false, unique = true)
    private String organisationName;
    @Column(nullable = false, unique = true)
    private String organisationEmail;
    @Column(nullable = false)
    private String organisationPassword;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    public OrganisationEntity(UUID organisationId, String organisationName, String organisationEmail, String organisationPassword,Boolean isDeleted) {
        this.organisationId = organisationId;
        this.organisationName = organisationName;
        this.organisationEmail = organisationEmail;
        this.organisationPassword = organisationPassword;
        this.isDeleted = isDeleted;
    }
    public OrganisationEntity() {}

    public UUID getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(UUID organisationId) {
        this.organisationId = organisationId;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getOrganisationEmail() {
        return organisationEmail;
    }

    public void setOrganisationEmail(String organisationEmail) {
        this.organisationEmail = organisationEmail;
    }

    public String getOrganisationPassword() {
        return organisationPassword;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setOrganisationPassword(String organisationPassword) {
        this.organisationPassword = organisationPassword;
    }
}
