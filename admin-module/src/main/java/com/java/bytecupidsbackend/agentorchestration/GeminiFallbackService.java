package com.java.bytecupidsbackend.agentorchestration;

import reactor.core.publisher.Flux;

public class GeminiFallbackService implements AgentService{

    @Override
    public Flux<String> getResponse(String prompt, String agentKey) {
        return Flux.empty();
    }
}
