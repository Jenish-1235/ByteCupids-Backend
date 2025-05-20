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

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
    }
}


dependencies {
    implementation(project(":shared-domain"))
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-web")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.azure:azure-ai-openai:1.0.0-beta.16") // or latest stable
    implementation("com.azure:azure-core:1.44.0")            // ensure core for AzureKeyCredential
    implementation("com.google.cloud:google-cloud-secretmanager:2.62.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // or other converter
    implementation("com.squareup.okhttp3:okhttp:4.9.3")

}