package com.java.bytecupidsbackend.presentation.controller.datacontrollers;

import com.java.bytecupidsbackend.domain.model.Module;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bytecupids/admin/save")
public class ModuleDataController {

    private final ModuleRepository moduleRepository;


    public ModuleDataController(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @PostMapping("/module")
    public void saveModule(@RequestBody Module module) {
        moduleRepository.saveModule(module);
    }

}
