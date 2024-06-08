package com.example.gasManager.core.exceptions.customer;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(String msg) {
        super(msg);
    }
}
