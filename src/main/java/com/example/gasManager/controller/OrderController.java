package com.example.gasManager.controller;


import com.example.gasManager.model.Order;
import com.example.gasManager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/order")
//    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
//        Optional<Order> order0 = orderService.createOrder(orderDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(order0.get());
//    }

//    @DeleteMapping("/order/{id}")
//    public ResponseEntity<Object> removeOrder(@PathVariable(value = "id") Long id) {
//        Optional<Object> order0 = orderService.deleteOrder(id);
//        if(order0.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(order0.get());
//    }
}
