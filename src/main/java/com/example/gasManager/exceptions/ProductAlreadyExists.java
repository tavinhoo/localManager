package com.example.gasManager.exceptions;

public class ProductAlreadyExists extends RuntimeException {
    public ProductAlreadyExists(String msg) {
        super(msg);
    }
}
