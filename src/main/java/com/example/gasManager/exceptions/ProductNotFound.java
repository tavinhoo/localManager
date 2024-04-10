package com.example.gasManager.exceptions;

public class ProductNotFound extends RuntimeException {

    public ProductNotFound(String msg) {
        super(msg);
    }
}
