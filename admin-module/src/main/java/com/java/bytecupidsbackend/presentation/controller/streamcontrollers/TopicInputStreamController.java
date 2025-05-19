package com.java.bytecupidsbackend.presentation.controller.streamcontrollers;

import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.presentation.dto.TopicInputRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
        ("/bytecupids/admin/generate")
public class TopicInputStreamController {

    private final Manager manager;

    public TopicInputStreamController(Manager manager) {
        this.manager = manager;
    }

    private String agentKey = "topic-list-generator";

    @PostMapping(value = "/topic-generator" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamTopicGenerator(@RequestBody TopicInputRequest request) {

        String accessToken = request.getAccessToken();
        String moduleInfo = request.getModuleInfo();
        String topicList = manager.getResponse(moduleInfo, agentKey);
        return Flux.just("Topics generated based on the prompt: " + request.getModuleInfo());
    }
}
