package com.example.gasManager.usecase.Order;

import com.example.gasManager.core.domain.Order;

public interface DeleteOrderUseCase {
    void deleteOrderById(Long orderId);
}
