package com.example.gasManager.model.exceptions;

public class CustomerHasActiveOrders extends RuntimeException {
    public CustomerHasActiveOrders(String msg) {
        super(msg);
    }
}
