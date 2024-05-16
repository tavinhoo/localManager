package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.usecase.customer.GetAllCustomersUseCase;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.domain.model.Customer;

import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllCustomersUseCase {

    private CustomerRepository customerRepository;

    public GetAllUsersUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
