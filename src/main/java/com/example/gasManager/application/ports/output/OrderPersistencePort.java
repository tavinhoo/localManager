package com.example.gasManager.application.ports.output;

import com.example.gasManager.core.domain.model.Order;

import java.util.List;

public interface OrderPersistencePort {
    void save(Order order);
    List<Order> findAll();
    Order findById(long id);
    void delete(Long orderId);
}
