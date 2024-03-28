package com.example.gasManager.exceptions;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(String msg) {
        super(msg);
    }
}
