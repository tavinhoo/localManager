package com.example.gasManager.usecase.customer;

public interface CheckActiveOrdersUseCase {
    Boolean customerHasActiveOrders(Long customerId);
}
