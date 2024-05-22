package com.example.gasManager.application.ports.input.customer;

public interface CheckActiveOrdersUseCase {
    Boolean customerHasActiveOrders(Long customerId);
}
