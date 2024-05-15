package com.example.gasManager.model.exceptions;

public class ProductAlreadyExists extends RuntimeException {
    public ProductAlreadyExists(String msg) {
        super(msg);
    }
}
