package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.LoginUserUseCase;
import com.java.bytecupidsbackend.application.usecase.RegisterUserUseCase;
import com.java.bytecupidsbackend.domain.model.User;
import com.java.bytecupidsbackend.presentation.dto.LoginResponse;
import com.java.bytecupidsbackend.presentation.dto.LoginRequest;
import com.java.bytecupidsbackend.presentation.dto.RegisterRequest;
import com.java.bytecupidsbackend.presentation.dto.RegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegisterUserUseCase registerUseCase;
    private final LoginUserUseCase loginUseCase;

    public AuthController(RegisterUserUseCase registerUseCase, LoginUserUseCase loginUseCase) {
        this.registerUseCase = registerUseCase;
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(registerUseCase.execute(request.getUsername(), request.getEmail(), request.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginUseCase.execute(request.getEmail(), request.getPassword()));
    }
}
