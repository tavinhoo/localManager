package com.example.gasManager.core.exceptions;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(String msg) {
        super(msg);
    }
}
