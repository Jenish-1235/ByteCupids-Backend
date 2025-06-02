package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;

public class Organisation {
    private UUID organisationId;
    private String organisationName;
    private String organisationEmail;
    private String organisationPassword;
    private Boolean isDeleted;

    public Organisation(UUID organisationId, String organisationName, String organisationEmail, String organisationPassword,Boolean isDeleted) {
        this.organisationId = organisationId;
        this.organisationName = organisationName;
        this.organisationEmail = organisationEmail;
        this.organisationPassword = organisationPassword;
        this.isDeleted = isDeleted;
    }
    public Organisation() {}

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
