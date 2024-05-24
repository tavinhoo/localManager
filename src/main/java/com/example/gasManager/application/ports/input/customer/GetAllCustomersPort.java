package com.example.gasManager.application.ports.input.customer;

import com.example.gasManager.core.domain.model.Customer;

import java.util.List;

public interface GetAllCustomersPort {

    List<Customer> getAll();
}
