package com.example.gasManager.model.exceptions;

public class OrderItemsIsEmpty extends RuntimeException {
    public OrderItemsIsEmpty(String msg) {
        super(msg);
    }
}
