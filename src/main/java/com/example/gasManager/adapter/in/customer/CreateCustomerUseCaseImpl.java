package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.usecase.customer.CreateUniqueCustomerUseCase;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.usecase.customer.CreateCustomerUseCase;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.exceptions.CustomerAlreadyExists;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final CreateUniqueCustomerUseCase createUniqueCustomerUseCase;

    public CreateCustomerUseCaseImpl(CustomerRepository customerRepository, CreateUniqueCustomerUseCase createUniqueCustomerUseCase) {
        this.customerRepository = customerRepository;
        this.createUniqueCustomerUseCase = createUniqueCustomerUseCase;
    }

    @Override
    public void createCustomer(Customer customer) {
        if(createUniqueCustomerUseCase.customersExist(customer.getName())) {
            throw new CustomerAlreadyExists("Já existe um cadastro com este nome!");
        }
    }
}
