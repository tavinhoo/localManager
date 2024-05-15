package com.example.gasManager.core.exceptions;

public class ProductAlreadyExists extends RuntimeException {
    public ProductAlreadyExists(String msg) {
        super(msg);
    }
}
