package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.ModuleEntity;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.OrganisationEntity;
import org.springframework.stereotype.Component;
import com.java.bytecupidsbackend.domain.model.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ModuleRepositoryAdapter implements ModuleRepository {

    private final JpaModuleRepository jpaModuleRepository;
    private final JpaOrganisationRepository jpaOrganisationRepository;

    public ModuleRepositoryAdapter(JpaModuleRepository jpaModuleRepository, JpaOrganisationRepository jpaOrganisationRepository) {
        this.jpaModuleRepository = jpaModuleRepository;
        this.jpaOrganisationRepository = jpaOrganisationRepository;
    }

    @Override
    public List<Module> getAllModules() {
        List<ModuleEntity> moduleEntities = jpaModuleRepository.findAll();
        List<Module> modules = new ArrayList<>();
        for (ModuleEntity moduleEntity : moduleEntities) {
            modules.add(new Module(moduleEntity.getModuleId(), moduleEntity.getModuleName(), moduleEntity.getNoOfTopics(), moduleEntity.getNoOfSubTopics(), moduleEntity.getPrerequisites(), moduleEntity.getTargetAudience(), moduleEntity.getEstimatedTime(), moduleEntity.getInterpretation(), moduleEntity.getAgentNotes(), moduleEntity.getDifficultyLevel(), moduleEntity.getLastUpdateTime(), String.valueOf(moduleEntity.getOrganization().getOrganisationId()), moduleEntity.getDeleted()));
        }
        return modules;
    }

    @Override
    public Optional<Module> getModuleByModuleId(UUID moduleId) {
        Optional<ModuleEntity> moduleEntityOptional = jpaModuleRepository.findByModuleId(moduleId);

        if (moduleEntityOptional.isPresent()) {
            ModuleEntity entity = moduleEntityOptional.get();

            Module module = new Module(
                    entity.getModuleId(),
                    entity.getModuleName(),
                    entity.getNoOfTopics(),
                    entity.getNoOfSubTopics(),
                    entity.getPrerequisites(),
                    entity.getTargetAudience(),
                    entity.getEstimatedTime(),
                    entity.getInterpretation(),
                    entity.getAgentNotes(),
                    entity.getDifficultyLevel(),
                    entity.getLastUpdateTime(),
                    entity.getOrganization().getOrganisationId().toString(),
                    entity.getDeleted()
            );
            return Optional.of(module);

        } else {
            return Optional.empty();

        }
    }


    @Override
    public void saveModule(Module module) {
        Optional<OrganisationEntity> organisationEntity = jpaOrganisationRepository.findByOrganisationId(UUID.fromString(module.getOrganization().trim()));

        OrganisationEntity organisation = organisationEntity.get();
        jpaModuleRepository.save(new ModuleEntity(module.getModuleId(), module.getModuleName(), module.getNoOfTopics(), module.getNoOfSubTopics(), module.getPrerequisites(), module.getTargetAudience(), module.getEstimatedTime(), module.getDifficultyLevel(), module.getAgentNotes(), module.getInterpretation(), module.getLastUpdateTime(), module.getDeleted(), organisation));
    }
}