package com.example.gasManager.usecase;

import com.example.gasManager.core.domain.Customer;

public interface EditCustomerUseCase {
    void editCustomer(Long customerId, Customer customer);
}
