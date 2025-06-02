package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.User;
import com.java.bytecupidsbackend.domain.repository.UserRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.adapter.UserRepositoryAdapter;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.UserEntity;
import com.java.bytecupidsbackend.infrastructure.security.JwtProvider;
import com.java.bytecupidsbackend.presentation.dto.LoginResponse;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public LoginResponse execute(String email, String password) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));

        if (userRepository.findByEmail(email).isEmpty()) {
            loginResponse.setMessage("User not found");
            loginResponse.setCode(400);
            loginResponse.setSuccess(false);
            loginResponse.setUser(null);
            return loginResponse;
        }

        User user = userRepository.findByEmail(email).get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            loginResponse.setCode(400);
            loginResponse.setSuccess(false);
            loginResponse.setUser(null);
            loginResponse.setMessage("Invalid Credentials");
            return loginResponse;
        }

        String accessToken = jwtProvider.generateToken(user);
        String refreshToken = jwtProvider.generateRefreshToken(user);
        loginResponse.setAccessToken(accessToken);
        loginResponse.setRefreshToken(refreshToken);
        loginResponse.setSuccess(true);
        user.setPassword("");
        loginResponse.setUser(user);
        loginResponse.setMessage("Login successful");
        loginResponse.setCode(200);
        return loginResponse;
    }
}