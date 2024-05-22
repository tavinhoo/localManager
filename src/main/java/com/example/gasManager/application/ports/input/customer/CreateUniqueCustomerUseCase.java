package com.example.gasManager.application.ports.input.customer;

public interface CreateUniqueCustomerUseCase {
    Boolean customersExist(String customerName);
}
