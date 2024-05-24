package com.example.gasManager.application.ports.input.customer;

public interface CheckActiveOrdersPort {
    Boolean customerHasActiveOrders(Long customerId);
}
