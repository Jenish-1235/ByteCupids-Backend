package com.java.bytecupidsbackend.domain.repository;


import com.java.bytecupidsbackend.domain.model.Organisation;

import java.util.Optional;
import java.util.UUID;

public interface OrganisationRepository {

    Optional<Organisation> findById(UUID organisation);
}
