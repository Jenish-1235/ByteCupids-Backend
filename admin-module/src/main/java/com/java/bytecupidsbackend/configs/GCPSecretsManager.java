package com.java.bytecupidsbackend.configs;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;
import com.google.protobuf.ByteString;
import org.springframework.stereotype.Component;

@Component
public class GCPSecretsManager {
    private final SecretManagerServiceClient client;

    public GCPSecretsManager() throws Exception {
        this.client = SecretManagerServiceClient.create();
    }

    public String getSecret(String projectId, String secretId) {
        SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretId, "latest");
        AccessSecretVersionResponse response = client.accessSecretVersion(secretVersionName);
        ByteString payload = response.getPayload().getData();
        return payload.toStringUtf8();
    }
}
