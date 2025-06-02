package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.infrastructure.persistence.entity.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaOrganisationRepository extends JpaRepository<OrganisationEntity,UUID> {
    Optional<OrganisationEntity> findByOrganisationId(UUID organisation);
}
