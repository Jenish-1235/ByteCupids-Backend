package com.java.bytecupidsbackend.application.agents;

public class ClaudeAiService implements AgentService {

    @Override
    public String getResponse(String prompt){
        return "Response from ClaudeAi";
    }
}
