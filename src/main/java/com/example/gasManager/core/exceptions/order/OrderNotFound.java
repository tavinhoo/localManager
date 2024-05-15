package com.example.gasManager.core.exceptions;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String msg) {
        super(msg);
    }
}
