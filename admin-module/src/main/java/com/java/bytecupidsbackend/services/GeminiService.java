package com.java.bytecupidsbackend.services;

import com.java.bytecupidsbackend.configs.OkHttpClientConfig;
import com.java.bytecupidsbackend.presentation.dto.ContentCurationRequest;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Component
public class GeminiService implements ExternalLLmService{

    private final OkHttpClient client;
    public GeminiService(OkHttpClientConfig okHttpClientConfig) {
        this.client = okHttpClientConfig.okHttpClient();
    }

    @Override
    public Flux<String> getStreamResponse(String agentKey, String systemPrompt, String userPrompt, double temperature) {
        String baseUrl = "https://agent-service-functions-959657611883.europe-west1.run.app";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("hello" , mediaType);

        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            return Flux.create(sink -> {
                client.newCall(request).enqueue(new okhttp3.Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }

                    @Override
                    public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String responseBody = response.body().string();
                            sink.next(responseBody);
                            sink.complete();
                        } else {
                            sink.error(new RuntimeException("Unexpected code " + response));
                        }
                    }
                });
            });
        } catch (Exception e) {
            return Flux.error(e);
        }
    }

    @Override
    public String getResponse(String agentKey, String systemPrompt, String userPrompt, double temperature) {
        String baseUrl = "https://agent-service-functions-959657611883.europe-west1.run.app";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("hello" , mediaType);

        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
