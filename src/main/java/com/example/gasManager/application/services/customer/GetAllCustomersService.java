package com.example.gasManager.application.services.customer;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerRepository;
import com.example.gasManager.application.ports.input.customer.GetAllCustomersUseCase;

import java.util.List;

public class GetAllCustomersService implements GetAllCustomersUseCase {

    private CustomerRepository customerRepository;

    public GetAllCustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
