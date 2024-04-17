package com.example.gasManager.exceptions;

public class OrderItemsNotEmptyException extends RuntimeException {
    public OrderItemsNotEmptyException(String msg) {
        super(msg);
    }
}
