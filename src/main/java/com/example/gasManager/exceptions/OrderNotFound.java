package com.example.gasManager.exceptions;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String msg) {
        super(msg);
    }
}
