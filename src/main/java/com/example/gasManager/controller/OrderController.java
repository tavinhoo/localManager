package com.example.gasManager.controller;


import com.example.gasManager.model.Order;
import com.example.gasManager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOneOrder(@PathVariable(value = "id") Long id) {
        Optional<Order> order0 = orderService.findById(id);
        if(order0.isEmpty()) {
            ResponseEntity.ok().body(order0.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok().body(orderService.findAll());
    }
}
