package com.example.gasManager.usecase.order;
import com.example.gasManager.core.domain.model.OrderItem;

public interface GetOrderItemUseCase {
    OrderItem getOrderItemById(Long orderItemid);
}
