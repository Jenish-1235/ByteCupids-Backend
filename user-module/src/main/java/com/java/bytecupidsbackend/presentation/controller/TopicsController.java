package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.TopicUseCase;
import com.java.bytecupidsbackend.presentation.dto.TopicsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bytecupids/lab")
public class TopicsController {

    private final TopicUseCase labTopicUseCase;
    public TopicsController(final TopicUseCase labTopicUseCase) {
        this.labTopicUseCase = labTopicUseCase;
    }

    @PostMapping("/get_topics")
    public ResponseEntity<?> getLabTopics(@RequestBody TopicsRequest request) {
        return ResponseEntity.ok().body(labTopicUseCase.getAllTopics(request.getModuleId()));
    }
}
