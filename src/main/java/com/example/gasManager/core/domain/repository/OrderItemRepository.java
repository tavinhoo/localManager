package com.example.gasManager.core.domain.repository;

import com.example.gasManager.core.domain.model.OrderItem;

public interface OrderItemRepository {
    void save(OrderItem orderItem);
    OrderItem findById(long id);
    void delete(Long orderItemId);
}
