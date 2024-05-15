package com.example.gasManager.model.exceptions;

public class OrderItemsNotEmptyException extends RuntimeException {
    public OrderItemsNotEmptyException(String msg) {
        super(msg);
    }
}
