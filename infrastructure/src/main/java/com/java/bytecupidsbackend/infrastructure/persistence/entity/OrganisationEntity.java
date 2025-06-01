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

    public OrganisationEntity(UUID organisationId, String organisationName, String organisationEmail, String organisationPassword) {
        this.organisationId = organisationId;
        this.organisationName = organisationName;
        this.organisationEmail = organisationEmail;
        this.organisationPassword = organisationPassword;
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

    public void setOrganisationPassword(String organisationPassword) {
        this.organisationPassword = organisationPassword;
    }
}
