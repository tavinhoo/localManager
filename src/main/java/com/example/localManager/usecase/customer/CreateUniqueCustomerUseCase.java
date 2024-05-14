package com.example.gasManager.usecase.customer;

public interface CreateUniqueCustomerUseCase {
    Boolean customersExist(String customerName);
}
