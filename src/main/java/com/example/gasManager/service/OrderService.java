package com.example.gasManager.service;

import com.example.gasManager.model.exceptions.OrderItemsIsEmpty;
import com.example.gasManager.model.exceptions.OrderItemsNotEmptyException;
import com.example.gasManager.model.exceptions.OrderNotFound;
import com.example.gasManager.model.Order;
import com.example.gasManager.model.OrderItem;
import com.example.gasManager.repository.CustomerRepository;
import com.example.gasManager.repository.OrderItemRepository;
import com.example.gasManager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

    public Optional<List<OrderItem>> findAllOrderItems() {
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        return Optional.of(orderItemList);
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

    public void saveOrderItem(Order order, OrderItem orderItem) {
        orderItemRepository.save(orderItem);
        order.getOrderItems().add(orderItem);
    }

    public Optional<Object> deleteItem(Long orderId, Long orderItemId) {
        if(orderRepository.existsById(orderId)) {
            Order o0 = orderRepository.findById(orderId).get();
            if(!o0.getOrderItems().isEmpty()) {
                for(OrderItem oi : o0.getOrderItems()) {
                    if(oi.getId() == orderItemId) {
                        orderItemRepository.delete(oi);
                    }
                }
                return Optional.of("Item removido!");
            } else {
                throw new OrderItemsIsEmpty("Não há nenhum item nesse pedido!");
            }
        } else {
            throw new OrderNotFound("Este pedido não foi encontrado ou não existe!");
        }
    }
}
