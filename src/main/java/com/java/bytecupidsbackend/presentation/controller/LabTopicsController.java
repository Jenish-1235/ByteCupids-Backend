package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.LabTopicUseCase;
import com.java.bytecupidsbackend.presentation.dto.LabTopicsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bytecupids/lab")
public class LabTopicsController {

    private final LabTopicUseCase labTopicUseCase;
    public LabTopicsController(final LabTopicUseCase labTopicUseCase) {
        this.labTopicUseCase = labTopicUseCase;
    }

    @GetMapping("/get_topics")
    public ResponseEntity<?> getLabTopics(@RequestBody LabTopicsRequest request) {
        return ResponseEntity.ok().body(labTopicUseCase.getAllTopics(request.getModuleId()));
    }
}
