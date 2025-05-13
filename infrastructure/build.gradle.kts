plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.java"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared-domain"))
    implementation(project(":admin-module"))
    // Add infra-specific dependencies here if needed
    implementation("org.springframework:spring-context:6.1.6")
    implementation("org.springframework:spring-web:6.1.6")
    implementation("org.springframework.data:spring-data-jpa:3.2.5")
    implementation("org.springframework.security:spring-security-core:6.2.4")
    implementation("org.springframework.security:spring-security-config:6.2.4")
    implementation("org.springframework.security:spring-security-web:6.2.4")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.hibernate.orm:hibernate-core:6.4.4.Final")
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
}