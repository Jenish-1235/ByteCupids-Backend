package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.Organisation;
import com.java.bytecupidsbackend.domain.repository.OrganisationRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.OrganisationEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class OrganisationRepositoryAdapter implements OrganisationRepository {

    private final JpaOrganisationRepository jpaOrganisationRepository;

    public OrganisationRepositoryAdapter(JpaOrganisationRepository jpaOrganisationRepository) {
        this.jpaOrganisationRepository = jpaOrganisationRepository;
    }


    @Override
    public Optional<Organisation> findById(UUID organisation) {
       return jpaOrganisationRepository.findByOrganisationId(organisation)
               .map(entity -> new Organisation(entity.getOrganisationId(),entity.getOrganisationName(),entity.getOrganisationEmail(),entity.getOrganisationPassword(),entity.getDeleted()));
    }
}
