package com.java.bytecupidsbackend.domain.repository;

import com.java.bytecupidsbackend.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
}
