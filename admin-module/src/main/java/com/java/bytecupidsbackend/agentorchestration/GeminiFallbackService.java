package com.java.bytecupidsbackend.agentorchestration;

import reactor.core.publisher.Flux;

public class GeminiFallbackService implements AgentService{

    @Override
    public Flux<String> getStreamResponse(String prompt, String agentKey) {
        return Flux.empty();
    }

    @Override
    public String getResponse(String prompt, String agentKey) {
        return "Sorry, I don't know how to answer that.";
    }
}
