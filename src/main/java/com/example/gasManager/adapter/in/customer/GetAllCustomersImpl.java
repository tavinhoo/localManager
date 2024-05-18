package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.domain.usecase.customer.GetAllCustomersUseCase;

import java.util.List;

public class GetAllCustomersImpl implements GetAllCustomersUseCase {

    private CustomerRepository customerRepository;

    public GetAllCustomersImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
