package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.User;
import com.java.bytecupidsbackend.domain.repository.UserRepository;
import com.java.bytecupidsbackend.infrastructure.security.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class LoginUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public String execute(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return String.valueOf(jwtProvider.generateToken(user));
    }
}