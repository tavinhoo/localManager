package com.example.gasManager.core.domain.repository;

import com.example.gasManager.core.domain.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    void save(OrderItem orderItem);
    OrderItem findById(Long id);
    void delete(Long orderItemId);
    List<OrderItem> findAll();
}
