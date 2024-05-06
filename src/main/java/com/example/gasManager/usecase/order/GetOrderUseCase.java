package com.example.gasManager.usecase.order;

import com.example.gasManager.core.domain.model.Order;

public interface GetOrderUseCase {
    Order getOrderById(Long orderId);
}
