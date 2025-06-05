package com.java.bytecupidsbackend.domain.repository;


import com.java.bytecupidsbackend.domain.model.Module;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository {
    List<Module> getAllModules();

    Optional<Module> getModuleByModuleId(UUID moduleId);

    void saveModule(Module module);

//    void deleteModule(UUID moduleId);
}
