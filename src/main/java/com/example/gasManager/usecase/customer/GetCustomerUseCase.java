package com.example.gasManager.usecase.customer;

import com.example.gasManager.core.domain.model.Customer;

public interface GetCustomerUseCase {
    Customer getCustomerById(Long customerId);
}
