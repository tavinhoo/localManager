package com.example.gasManager.model.exceptions;

public class ProductNotFound extends RuntimeException {

    public ProductNotFound(String msg) {
        super(msg);
    }
}
