package com.java.bytecupidsbackend.agents;

import com.java.bytecupidsbackend.agentorchestration.AgentService;
import com.java.bytecupidsbackend.services.ClaudeService;
import reactor.core.publisher.Flux;

public class TopicListGenerator implements AgentService {

    private final ClaudeService claudeService;

    public TopicListGenerator(ClaudeService claudeService) {
        this.claudeService = claudeService;
    }

    @Override
    public Flux<String> getStreamResponse(String prompt, String agentKey) {
        return Flux.just("Topics generated based on the prompt: " + prompt);
    }

    @Override
    public String getResponse(String prompt, String agentKey) {
        return "Topics generated based on the prompt: " + prompt;
    }
}
