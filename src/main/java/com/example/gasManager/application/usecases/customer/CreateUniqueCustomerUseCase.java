package com.example.gasManager.application.usecases.customer;

public interface CreateUniqueCustomerUseCase {
    Boolean customersExist(String customerName);
}
