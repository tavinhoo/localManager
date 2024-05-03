package com.example.gasManager.usecase.Customer;

public interface CheckActiveOrdersUseCase {
    Boolean customerHasActiveOrders(Long customerId);
}
