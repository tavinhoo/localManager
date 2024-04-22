package com.example.gasManager.controller;


import com.example.gasManager.model.OrderItem;
import com.example.gasManager.model.exceptions.OrderItemsIsEmpty;
import com.example.gasManager.model.exceptions.OrderNotFound;
import com.example.gasManager.model.Order;
import com.example.gasManager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAllOrders());
    }

    @GetMapping("/order/{id}")
    private ResponseEntity<Order> getOneOrder(@PathVariable(value = "id") Long id) {
        Optional<Order> order0 = orderService.findOrderById(id);
        if(order0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(order0.get());
    }

    @GetMapping("order/items")
    private ResponseEntity<List<OrderItem>> getAllOrderItems() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAllOrderItems().get());
    }

//    @PostMapping("/order")
//    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
//        Optional<Order> order0 = orderService.createOrder(orderDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(order0.get());
//    }

    @DeleteMapping("/order/{orderId}/items/{itemId}")
    public ResponseEntity<Object> deleteItem(@PathVariable(value = "orderId") Long orderId, @PathVariable(value = "itemId") Long itemId) {
        try {
            Optional<Object> item0 = orderService.deleteItem(orderId, itemId);
            return ResponseEntity.status(HttpStatus.OK).body(item0.get());
        } catch (OrderItemsIsEmpty error ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }catch (OrderNotFound error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
}
