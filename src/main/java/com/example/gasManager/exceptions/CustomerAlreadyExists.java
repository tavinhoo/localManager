package com.example.gasManager.exceptions;

public class CustomerAlreadyExists extends RuntimeException {
    public CustomerAlreadyExists(String msg) {
        super(msg);
    }
}
