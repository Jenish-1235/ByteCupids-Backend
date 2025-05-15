package com.java.bytecupidsbackend.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "azure.openai")
public class AzureOpenAIProperties {

    private Map<String, AgentConfig> agents = new HashMap<>();

    public Map<String, AgentConfig> getAgents() {
        System.out.println(agents);
        return agents;
    }

    public void setAgents(Map<String, AgentConfig> agents) {
        this.agents = agents;
    }

    public static class AgentConfig {
        private String deploymentId;
        private String endPoint;

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
    }
}
