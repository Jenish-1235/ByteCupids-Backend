package com.java.bytecupidsbackend.agentorchestration;

import com.java.bytecupidsbackend.agents.*;
import com.java.bytecupidsbackend.services.AzureOpenAIService;
import com.java.bytecupidsbackend.services.ClaudeService;
import com.java.bytecupidsbackend.services.GeminiService;
import org.springframework.stereotype.Component;

@Component
public class AgentFactory {

    private final AzureOpenAIService openAIService;
    private final ClaudeService claudService;
    private final GeminiService geminiService;

    public AgentFactory(AzureOpenAIService service, ClaudeService claudService, GeminiService geminiService) {
        this.openAIService = service;
        this.claudService = claudService;
        this.geminiService = geminiService;
    }

    public AgentService getAgent(String agentKey){
        switch (agentKey) {
            case "module-input-formatter":
                return new ModuleInputFormatter(openAIService);
            case "topic-list-generator":
                return new TopicListGenerator(openAIService);
                case "academic-content-creator":
                return new AcademicContentCreator(openAIService);
            case "practical-content-creator":
                return new PracticalContentCreator(openAIService);
            case "content-validator":
                return new ContentValidator(openAIService);
            default:
                return new GeminiFallbackService();
        }
    }
}
