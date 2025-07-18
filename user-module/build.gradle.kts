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
    implementation(project(":infrastructure"))
    // Add other dependencies if needed
     implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-context")
    implementation("org.springframework.boot:spring-boot-starter-security")
}