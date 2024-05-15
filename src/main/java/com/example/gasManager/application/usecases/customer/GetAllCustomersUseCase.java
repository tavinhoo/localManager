package com.example.gasManager.application.usecases.customer;

import com.example.gasManager.core.domain.model.Customer;

import java.util.List;

public interface GetAllCustomersUseCase {

    List<Customer> getAllCustomers();
}
