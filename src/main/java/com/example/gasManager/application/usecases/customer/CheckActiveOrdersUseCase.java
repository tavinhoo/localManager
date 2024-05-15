package com.example.gasManager.application.usecases.customer;

public interface CheckActiveOrdersUseCase {
    Boolean customerHasActiveOrders(Long customerId);
}
