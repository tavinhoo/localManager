package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.GetAllCustomersUseCase;
import com.example.gasManager.application.ports.output.CustomerRepository;
import com.example.gasManager.core.domain.model.Customer;

import java.util.List;

public class GetAllUsersService implements GetAllCustomersUseCase {

    private CustomerRepository customerRepository;

    public GetAllUsersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
