package com.example.gasManager.usecase.Customer;

import com.example.gasManager.core.domain.Customer;

public interface GetCustomerUseCase {
    Customer getCustomerById(Long customerId);
}
