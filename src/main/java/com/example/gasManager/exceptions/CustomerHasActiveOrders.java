package com.example.gasManager.exceptions;

public class CustomerHasActiveOrders extends RuntimeException {
    public CustomerHasActiveOrders(String msg) {
        super(msg);
    }
}
