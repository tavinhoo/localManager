package com.example.gasManager.core.exceptions;

public class CustomerHasActiveOrders extends RuntimeException {
    public CustomerHasActiveOrders(String msg) {
        super(msg);
    }
}
