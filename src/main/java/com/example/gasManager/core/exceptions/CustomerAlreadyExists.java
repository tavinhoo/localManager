package com.example.gasManager.core.exceptions;

public class CustomerAlreadyExists extends RuntimeException {
    public CustomerAlreadyExists(String msg) {
        super(msg);
    }
}
