package com.example.gasManager.core.domain.repository;

import com.example.gasManager.core.domain.model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    User findById(Long userId);
    void deleteById(Long userId);
    List<User> findAll();
}
