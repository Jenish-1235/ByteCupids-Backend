package com.java.bytecupidsbackend.presentation.controller.streamcontrollers;

import com.google.api.client.json.Json;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.bytecupidsbackend.agentorchestration.Manager;
import com.java.bytecupidsbackend.presentation.dto.TopicInputRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
        @RequestMapping("/bytecupids/admin/generate")
public class TopicInputStreamController {

    private final Manager manager;

    public TopicInputStreamController(Manager manager) {
        this.manager = manager;
    }

    private String agentKey = "topic-list-generator";

    @PostMapping(value = "/topic-generator" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamTopicGenerator(@RequestBody TopicInputRequest request) {

        String accessToken = request.getAccessToken();

        String prompt = new Gson().toJson(request.getModuleInfo());
        System.out.println(prompt);
        String topicList = manager.getResponse(prompt, agentKey);
        return Flux.just(topicList);
    }
}
