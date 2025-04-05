package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.LoginUserUseCase;
import com.java.bytecupidsbackend.application.usecase.RegisterUserUseCase;
import com.java.bytecupidsbackend.domain.model.User;
import com.java.bytecupidsbackend.presentation.dto.AuthResponse;
import com.java.bytecupidsbackend.presentation.dto.LoginRequest;
import com.java.bytecupidsbackend.presentation.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        registerUseCase.execute(request.getUsername(), request.getEmail(), request.getPassword());
        return ResponseEntity.ok("Registered Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String token = loginUseCase.execute(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
