package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.User;
import com.java.bytecupidsbackend.domain.repository.UserRepository;
import com.java.bytecupidsbackend.infrastructure.security.JwtProvider;
import com.java.bytecupidsbackend.presentation.dto.LoginResponse;
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

    public LoginResponse execute(String email, String password) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));

        if (!userRepository.findByEmail(email).isPresent()) {
            loginResponse.setMessage("User not found");
            loginResponse.setStatus("error");
            loginResponse.setCode(400);
            loginResponse.setSuccess(false);
            loginResponse.setUser(null);
            loginResponse.setError("Email not registered");
            return loginResponse;
        }

        User user = userRepository.findByEmail(email).get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            loginResponse.setError("Wrong password");
            loginResponse.setStatus("error");
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
        loginResponse.setStatus("success");
        loginResponse.setSuccess(true);
        user.setPassword("");
        loginResponse.setUser(user);
        loginResponse.setMessage("Login successful");
        return loginResponse;
    }
}