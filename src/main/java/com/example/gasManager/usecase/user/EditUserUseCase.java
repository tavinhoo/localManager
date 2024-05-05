package com.example.gasManager.usecase.user;

import com.example.gasManager.core.domain.User;

public interface EditUserUseCase {
    User editUser(Long userId, User user);
}
