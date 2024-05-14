package com.example.gasManager.model.exceptions;

public class CustomerAlreadyExists extends RuntimeException {
    public CustomerAlreadyExists(String msg) {
        super(msg);
    }
}
