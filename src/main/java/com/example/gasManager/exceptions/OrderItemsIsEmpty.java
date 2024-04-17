package com.example.gasManager.exceptions;

public class OrderItemsIsEmpty extends RuntimeException {
    public OrderItemsIsEmpty(String msg) {
        super(msg);
    }
}
