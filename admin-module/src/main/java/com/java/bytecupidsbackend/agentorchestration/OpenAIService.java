package com.java.bytecupidsbackend.agentorchestration;

public class OpenAIService implements AgentService {
    @Override
    public String getResponse(String prompt){
        return "Response from OpenAI";
    }
}
