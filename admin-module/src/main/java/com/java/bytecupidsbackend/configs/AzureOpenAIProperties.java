package com.java.bytecupidsbackend.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "azure.openai")
public class AzureOpenAIProperties {

    private Map<String, AgentConfig> agents;

    public Map<String, AgentConfig> getAgents() {
        return agents;
    }

    public void setAgents(Map<String, AgentConfig> agents) {
        this.agents = agents;
    }

    public static class AgentConfig {
        private String deploymentId;
        private String endPoint;
        private String systemPrompt;

        public String getDeploymentId() {
            return deploymentId;
        }

        public void setDeploymentId(String deploymentId) {
            this.deploymentId = deploymentId;
        }

        public String getEndPoint() {
            return endPoint;
        }

        public void setEndPoint(String endPoint) {
            this.endPoint = endPoint;
        }

        public String getSystemPrompt() {
            return systemPrompt;
        }

        public void setSystemPrompt(String systemPrompt) {
            this.systemPrompt = systemPrompt;
        }

    }
}
