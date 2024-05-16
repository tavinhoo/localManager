package com.example.gasManager.adapter.in.customer;


import com.example.gasManager.core.domain.usecase.customer.CreateUniqueCustomerUseCase;
import com.example.gasManager.core.domain.repository.CustomerRepository;

public class CreateUniqueCustomerUseCaseImpl implements CreateUniqueCustomerUseCase {

    private final CustomerRepository customerRepository;

    public CreateUniqueCustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Boolean customersExist(String customerName) {
        return customerRepository.existsByName(customerName);
    }
}
