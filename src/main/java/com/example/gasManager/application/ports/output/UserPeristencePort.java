package com.example.gasManager.application.ports.output;

import com.example.gasManager.core.domain.model.User;

import java.util.List;

public interface UserPeristencePort {
    void save(User user);
    User findById(Long userId);
    void deleteById(Long userId);
    List<User> findAll();
}
