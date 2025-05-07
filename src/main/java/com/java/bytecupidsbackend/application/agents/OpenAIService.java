package com.java.bytecupidsbackend.application.agents;

public class OpenAIService implements AgentService {
    @Override
    public String getResponse(String prompt){
        return "Response from OpenAI";
    }
}
