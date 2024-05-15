package com.example.gasManager.core.exceptions;

public class OrderItemsIsEmpty extends RuntimeException {
    public OrderItemsIsEmpty(String msg) {
        super(msg);
    }
}
