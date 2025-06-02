package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.TopicUseCase;
import com.java.bytecupidsbackend.presentation.dto.TopicsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bytecupids/lab")
public class TopicsController {

    private final TopicUseCase labtopicUseCase;

    public TopicsController(final TopicUseCase labtopicUseCase) {
        this.labtopicUseCase = labtopicUseCase;
    }

    @PostMapping("/get_topics")
    public ResponseEntity<?> getLabTopics(@RequestBody TopicsRequest request){
        return ResponseEntity.ok().body(labtopicUseCase.getAllTopics(request.getModuleId()));
    }
}
