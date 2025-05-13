package com.java.bytecupidsbackend.domain.model;

import java.util.UUID;

public class User {
    private UUID uuid;
    private String username;
    private String email;
    private String password;

    public User(UUID uuid, String username, String email, String password) {
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");
        this.uuid = uuid;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(UUID uuid , String username, String email) {
        this(uuid, username, email, "");
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
