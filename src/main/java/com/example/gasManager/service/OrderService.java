package com.example.gasManager.service;


import com.example.gasManager.exceptions.OrderItemsNotEmptyException;
import com.example.gasManager.exceptions.OrderNotFound;
import com.example.gasManager.model.Order;
import com.example.gasManager.repository.CustomerRepository;
import com.example.gasManager.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Order> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
    public Optional<Order> findOrderById(Long id) {
        if(!orderRepository.existsById(id)) {
            throw new OrderNotFound("Pedido não encontrado!");
        }
        return orderRepository.findById(id);
    }

    public Optional<Order> saveOrder(Order order) {
        return Optional.of(orderRepository.save(order));
    }

    public Optional<Object> deleteOrder(Long id) {
          if(orderRepository.existsById(id)) {
                Order o0 = orderRepository.findById(id).get();
                if(o0.getOrderItems().isEmpty()) {
                    orderRepository.delete(o0);
                    return Optional.of("Pedido excluido com sucesso!");
                } else {
                    throw new OrderItemsNotEmptyException("Este pedido contém itens ativos! Id do pedido: " + o0.getOrder_id());
                }
          }
        throw new OrderNotFound("Pedido não encontrado!");
    }
}
