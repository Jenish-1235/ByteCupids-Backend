package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.User;
import com.java.bytecupidsbackend.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void execute(String username, String email, String password) {
        if (userRepository.findByEmail(email).isPresent())
            throw new RuntimeException("Email already registered");

        String hashed = passwordEncoder.encode(password);
        User user = new User(username, email, hashed);
        userRepository.save(user);
    }
}
