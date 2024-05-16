package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.usecase.customer.CheckIdExists;
import com.example.gasManager.core.domain.usecase.customer.GetCustomerUseCase;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.exceptions.CustomerNotFound;

public class GetCustomerUseCaseImpl implements GetCustomerUseCase {

    private CustomerRepository customerRepository;
    private CheckIdExists checkIdExists;

    public GetCustomerUseCaseImpl(CustomerRepository customerRepository, CheckIdExists checkIdExists) {
        this.customerRepository = customerRepository;
        this.checkIdExists = checkIdExists;
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        if(!checkIdExists.idExists(customerId)) {
            throw new CustomerNotFound("Customer not found");
        }
        return customerRepository.findById(customerId);
    }
}
