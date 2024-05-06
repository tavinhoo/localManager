package com.example.gasManager.usecase.customer;

import com.example.gasManager.core.domain.model.Customer;

public interface EditCustomerUseCase {
    void editCustomer(Long customerId, Customer customer);
}
