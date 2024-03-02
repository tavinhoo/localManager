package com.example.gasManager.service;


import com.example.gasManager.model.Customer;
import com.example.gasManager.model.Order;
import com.example.gasManager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> findById(Long id) {
        if(orderRepository.existsById(id)) {
            return orderRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> save(Order order) {
        return Optional.of(orderRepository.save(order));
    }

    public Optional<Order> updateOrder(Long id, Order order) {
        Order order0 = new Order();
        if(orderRepository.existsById(id)) {
            order0 = orderRepository.findById(id).get();
            order0 = order;
            return Optional.of(orderRepository.save(order0));
        }
        return Optional.empty();
    }

    public Optional<Order> delete(Long id) {
        Optional<Order> order0 = orderRepository.findById(id);
        if(order0.isEmpty()) {
            return Optional.empty();
        }
        return order0;
    }
}
