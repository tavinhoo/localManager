package com.example.gasManager.application.ports.output;

import com.example.gasManager.core.domain.model.OrderItem;

import java.util.List;

public interface OrderItemPersistencePort {
    void save(OrderItem orderItem);
    OrderItem findById(Long id);
    void delete(Long orderItemId);
    List<OrderItem> findAll();
}
