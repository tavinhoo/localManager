package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckIdExistsUseCase;
import com.example.gasManager.application.ports.input.customer.GetCustomerUseCase;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerRepository;
import com.example.gasManager.core.exceptions.CustomerNotFound;

public class GetCustomerService implements GetCustomerUseCase {

    private CustomerRepository customerRepository;
    private CheckIdExistsUseCase checkIdExistsUseCase;

    public GetCustomerService(CustomerRepository customerRepository, CheckIdExistsUseCase checkIdExists) {
        this.customerRepository = customerRepository;
        this.checkIdExistsUseCase = checkIdExists;
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        if(!checkIdExistsUseCase.idExists(customerId)) {
            throw new CustomerNotFound("Customer not found");
        }
        return customerRepository.findById(customerId);
    }
}
