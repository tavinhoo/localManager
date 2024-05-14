package com.example.gasManager.core.domain.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private Instant date;
    private Customer customer;
    List<OrderItem> orderItemList = new ArrayList<>();

    public Order() {
    }

    public Order(Instant date, Customer customer, List<OrderItem> orderItemList) {
        this.date = date;
        this.customer = customer;
        this.orderItemList = orderItemList;
    }

    public Long getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}

