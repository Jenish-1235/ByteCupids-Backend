package com.java.bytecupidsbackend.presentation.dto;

public class TopicDeleteRequest {

    private String topicId;
    private String accessToken;

    public TopicDeleteRequest(String topicId, String accessToken) {
        this.topicId = topicId;
        this.accessToken = accessToken;
    }

    public TopicDeleteRequest() {}

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
