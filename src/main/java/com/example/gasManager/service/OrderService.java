package com.example.gasManager.service;


import com.example.gasManager.DTO.OrderDTO;
import com.example.gasManager.model.Customer;
import com.example.gasManager.model.Order;
import com.example.gasManager.repository.CustomerRepository;
import com.example.gasManager.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Order> findById(Long id) {
        if(orderRepository.existsById(id)) {
            return orderRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> saveOrder(OrderDTO orderDTO) {
        Order order0 = new Order();
        BeanUtils.copyProperties(orderDTO, order0);
        return Optional.of(orderRepository.save(order0));
    }

    public List<Order> saveAll(List<Order> orders) {
        return orderRepository.saveAll(orders);
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

    public Optional<Object> deleteOrder(Long id) {
        Optional<Order> order0 = orderRepository.findById(id);
        if(order0.isEmpty()) {
            return Optional.empty();
        }
        orderRepository.delete(order0.get());
        return Optional.of("ORDER HAS BEEN DELETED!");
    }

    public List<Order> getAllCustomersOrders(Long id) {
        Optional<Customer> customer0 = customerRepository.findById(id);
        if(customer0.isEmpty()) {
            throw new RuntimeException("Customer not found!");
        }

        return customer0.get().getWishList();
    }

}
