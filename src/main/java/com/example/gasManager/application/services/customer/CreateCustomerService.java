package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CreateUniqueCustomerUseCase;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.input.customer.CreateCustomerUseCase;
import com.example.gasManager.application.ports.output.CustomerRepository;
import com.example.gasManager.core.exceptions.CustomerAlreadyExists;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements CreateCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final CreateUniqueCustomerUseCase createUniqueCustomerUseCase;

    public CreateCustomerService(CustomerRepository customerRepository, CreateUniqueCustomerUseCase createUniqueCustomerUseCase) {
        this.customerRepository = customerRepository;
        this.createUniqueCustomerUseCase = createUniqueCustomerUseCase;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        if(createUniqueCustomerUseCase.customersExist(customer.getName())) {
            throw new CustomerAlreadyExists("Já existe um cadastro com este nome!");
        }
        return customerRepository.save(customer);
    }
}
