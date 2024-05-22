package com.example.gasManager.application.services.customer;


import com.example.gasManager.application.ports.input.customer.CreateUniqueCustomerUseCase;
import com.example.gasManager.application.ports.output.CustomerRepository;

public class CreateUniqueCustomerService implements CreateUniqueCustomerUseCase {

    private final CustomerRepository customerRepository;

    public CreateUniqueCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Boolean customersExist(String customerName) {
        return customerRepository.existsByName(customerName);
    }
}
