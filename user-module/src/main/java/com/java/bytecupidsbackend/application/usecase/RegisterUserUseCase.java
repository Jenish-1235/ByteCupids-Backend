package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.User;
import com.java.bytecupidsbackend.domain.repository.UserRepository;
import com.java.bytecupidsbackend.presentation.dto.RegisterResponse;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse execute(String username, String email, String password) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setTimestamp(String.valueOf(new Date().getTime()));
        if (userRepository.findByEmail(email).isPresent()) {
            User user = userRepository.findByEmail(email).get();
            user.setPassword("");
            registerResponse.setMessage("Email already registered");
            registerResponse.setCode(400);
            registerResponse.setUser(user);
            registerResponse.setSuccess(false);
            return registerResponse;
        }

        String hashed = passwordEncoder.encode(password);
        User user = new User(username, email, hashed);
        userRepository.save(user);
        user = userRepository.findByEmail(email).get();
        registerResponse.setMessage("Success");
        registerResponse.setCode(200);
        user.setPassword("");
        registerResponse.setUser(user);
        registerResponse.setSuccess(true);
        return registerResponse;
    }
}
