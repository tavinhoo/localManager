package com.example.gasManager.core.exceptions.customer;

public class CustomerHasActiveOrders extends RuntimeException {
    public CustomerHasActiveOrders(String msg) {
        super(msg);
    }
}
