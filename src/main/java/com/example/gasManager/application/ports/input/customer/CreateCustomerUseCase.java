package com.example.gasManager.application.ports.input.customer;

import com.example.gasManager.core.domain.model.Customer;

public interface CreateCustomerUseCase {
    void createCustomer(Customer customer);
}
