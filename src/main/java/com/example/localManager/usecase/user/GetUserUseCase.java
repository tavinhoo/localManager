package com.example.gasManager.usecase.user;

import com.example.gasManager.core.domain.model.User;

public interface GetUserUseCase {
    User getUser(Long userId);
}
