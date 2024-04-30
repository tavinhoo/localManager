package com.example.gasManager.core.exceptions;

public class OrderItemsNotEmptyException extends RuntimeException {
    public OrderItemsNotEmptyException(String msg) {
        super(msg);
    }
}
