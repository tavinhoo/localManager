package com.example.gasManager.core.domain.usecase.customer;

public interface CheckActiveOrdersUseCase {
    Boolean customerHasActiveOrders(Long customerId);
}
