package com.java.bytecupidsbackend.domain.model;

public class User {
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email) {
        this(username, email, "");
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
