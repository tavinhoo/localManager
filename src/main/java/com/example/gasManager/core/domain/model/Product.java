package com.example.gasManager.core.domain.model;

import java.util.List;

public class Product {

    private Long id;
    private String name;
    private Double price;

    private List<OrderItem> orderItemList;

    public Product() {
    }

    public Product(String name, Double price, List<OrderItem> orderItemList) {
        this.name = name;
        this.price = price;
        this.orderItemList = orderItemList;
    }
}
