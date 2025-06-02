package com.java.bytecupidsbackend.domain.repository;


import com.java.bytecupidsbackend.domain.model.Module;

import java.util.List;

public interface ModuleRepository {
    List<Module> getAllModules();

    void saveModule(Module module);
}
