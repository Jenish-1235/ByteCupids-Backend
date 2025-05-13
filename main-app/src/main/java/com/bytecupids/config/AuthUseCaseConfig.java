package com.bytecupids.config;

import com.java.bytecupidsbackend.application.usecase.LoginUserUseCase;
import com.java.bytecupidsbackend.application.usecase.RegisterUserUseCase;
import com.java.bytecupidsbackend.domain.repository.UserRepository;
import com.java.bytecupidsbackend.infrastructure.security.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class AuthUseCaseConfig {

    @Bean
    public RegisterUserUseCase registerUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new RegisterUserUseCase(userRepository, passwordEncoder);
    }

    @Bean
    public LoginUserUseCase loginUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        return new LoginUserUseCase(userRepository, passwordEncoder, jwtProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
