package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.SubTopicUseCase;
import com.java.bytecupidsbackend.presentation.dto.SubTopicsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bytecupids/lab")
public class SubTopicsController {

    private final SubTopicUseCase labSubTopicUseCase;
    public SubTopicsController(final SubTopicUseCase labSubTopicUseCase) {
        this.labSubTopicUseCase = labSubTopicUseCase;
    }

    @PostMapping("/get_subtopics")
    public ResponseEntity<?> getLabSubTopics(@RequestBody SubTopicsRequest request) {
        return ResponseEntity.ok().body(labSubTopicUseCase.getAllSubTopics(request.getModuleId()));
    }
}
