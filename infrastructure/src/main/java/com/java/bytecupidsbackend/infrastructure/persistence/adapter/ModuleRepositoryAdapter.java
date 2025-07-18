package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.ModuleEntity;
import org.springframework.stereotype.Component;
import com.java.bytecupidsbackend.domain.model.Module;
import java.util.ArrayList;
import java.util.List;

@Component
public class ModuleRepositoryAdapter implements ModuleRepository {
    private final JpaModuleRepository jpaModuleRepository;

    public ModuleRepositoryAdapter(JpaModuleRepository jpaModuleRepository){this.jpaModuleRepository = jpaModuleRepository;}

    @Override
    public List<Module> getAllModules(){
        List<ModuleEntity> moduleEntities = jpaModuleRepository.findAll();
        List<Module> modules = new ArrayList<>();
        for(ModuleEntity moduleEntity : moduleEntities){
            modules.add(new Module(moduleEntity.getModule_id() , moduleEntity.getModuleName(), moduleEntity.getNoOfTopics(), moduleEntity.getNoOfSubTopics(),moduleEntity.getDifficultyLevel(),moduleEntity.getEstimatedTime(),moduleEntity.getAgentNotes(),moduleEntity.getInterpretation(),moduleEntity.getOrganizationId(),moduleEntity.getLastUpdatedTime(),moduleEntity.getTargetAudience(),moduleEntity.getPrerequisites()));
        }
        return modules;
    }
}
