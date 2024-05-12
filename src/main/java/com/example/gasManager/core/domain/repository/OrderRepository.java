package com.example.gasManager.core.domain.repository;

import com.example.gasManager.core.domain.model.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
    Order findById(long id);
    void delete(Long orderId);
}
