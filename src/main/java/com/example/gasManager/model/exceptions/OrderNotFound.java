package com.example.gasManager.model.exceptions;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String msg) {
        super(msg);
    }
}
