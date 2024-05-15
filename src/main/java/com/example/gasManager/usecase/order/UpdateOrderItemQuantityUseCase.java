package com.example.gasManager.usecase.order;

public interface UpdateOrderItemQuantityUseCase {
    void updateOrderItemQuantity(Long orderItemId, int quantity);
}
