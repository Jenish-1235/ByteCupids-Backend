package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.User;
import com.java.bytecupidsbackend.domain.repository.UserRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository jpaRepo;

    public UserRepositoryAdapter(JpaUserRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepo.findByEmail(email)
                .map(entity -> new User(entity.getUsername(), entity.getEmail(), entity.getPassword()));
    }

    @Override
    public void save(User user) {
        jpaRepo.save(new UserEntity(user.getUsername(), user.getEmail(), user.getPassword()));
    }
}