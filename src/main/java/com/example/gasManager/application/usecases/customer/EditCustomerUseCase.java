package com.example.gasManager.application.usecases.customer;

import com.example.gasManager.core.domain.model.Customer;

public interface EditCustomerUseCase {
    void editCustomer(Long customerId, Customer customer);
}
