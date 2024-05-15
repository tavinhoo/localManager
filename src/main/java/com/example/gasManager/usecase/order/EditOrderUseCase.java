package com.example.gasManager.usecase.order;

import com.example.gasManager.core.domain.model.Order;

public interface EditOrderUseCase {
    Order editOrder(Long orderId, Order order);
}
