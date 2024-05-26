package com.example.gasManager.infrastructure.adapters.persistence.order;

import com.example.gasManager.application.ports.output.OrderItemPersistencePort;
import com.example.gasManager.core.domain.model.OrderItem;

import java.util.List;

public class OrderPersistenceAdapter implements OrderItemPersistencePort {
    @Override
    public void save(OrderItem orderItem) {

    }

    @Override
    public OrderItem findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long orderItemId) {

    }

    @Override
    public List<OrderItem> findAll() {
        return List.of();
    }
}
