package com.example.gasManager.core.domain.usecase.customer;

public interface CreateUniqueCustomerUseCase {
    Boolean customersExist(String customerName);
}
