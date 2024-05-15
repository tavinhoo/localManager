package com.example.gasManager.model.exceptions;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(String msg) {
        super(msg);
    }
}
