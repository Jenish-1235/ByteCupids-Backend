package com.java.bytecupidsbackend.agentorchestration;

public class GeminiService implements AgentService {

    @Override
    public String getResponse(String prompt){
        return "Response from Gemini";
    }
}
