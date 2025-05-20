package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.ModuleEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
            modules.add(new Module(moduleEntity.getModule_id() , moduleEntity.getModuleName(), moduleEntity.getNoOfTopics(), moduleEntity.getNoOfSubTopics(),moduleEntity.getDifficultyLevel()));
        }
        return modules;
    }

    @Override
    public void saveModule(Module module) {
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setModule_id(module.getModuleId());
        moduleEntity.setModuleName(module.getName());
        moduleEntity.setNoOfTopics(module.getNoOfTopics());
        moduleEntity.setNoOfSubTopics(module.getNoOfSubTopics());
        moduleEntity.setDifficultyLevel(module.getDifficultyLevel());
        jpaModuleRepository.save(moduleEntity);
    }
}
