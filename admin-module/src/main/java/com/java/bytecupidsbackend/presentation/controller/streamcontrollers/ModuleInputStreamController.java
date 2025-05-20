package com.java.bytecupidsbackend.presentation.controller.streamcontrollers;

import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.presentation.dto.ModuleInputRequest;
import com.java.bytecupidsbackend.promptdirectory.ModuleInputFormatterPromptProvider;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/bytecupids/admin/generate")
public class ModuleInputStreamController {

    private final Manager manager;
    public ModuleInputStreamController(Manager manager) {
        this.manager = manager;
    }
    private String agentKey = "module-input-formatter";

    @PostMapping(value = "/module-input" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamModuleInput(@RequestBody ModuleInputRequest request) {
        String moduleName = request.getModuleName();
        String moduleMetadata = request.getModuleMetadata();
        String prompt = moduleName + "\n" + moduleMetadata;
        String formattedMetadata = manager.getResponse(prompt, agentKey);
        return Flux.just(formattedMetadata);
    }


}
