package com.java.bytecupidsbackend.configs;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OkHttpClientConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
