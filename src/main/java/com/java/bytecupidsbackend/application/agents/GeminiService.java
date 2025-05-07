package com.java.bytecupidsbackend.application.agents;

public class GeminiService implements AgentService {

    @Override
    public String getResponse(String prompt){
        return "Response from Gemini";
    }
}
