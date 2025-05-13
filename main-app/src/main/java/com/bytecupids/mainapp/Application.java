package com.bytecupids.mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.bytecupids",                  // your main app/config/security
        "com.java.bytecupidsbackend"       // your user module, controllers, repositories
})
@EnableJpaRepositories(basePackages = "com.java.bytecupidsbackend.infrastructure.persistence.adapter")
@EntityScan(basePackages = "com.java.bytecupidsbackend.infrastructure.persistence.entity")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}