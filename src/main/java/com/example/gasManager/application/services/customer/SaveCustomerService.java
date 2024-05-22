package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.SaveCustomerUseCase;
import com.example.gasManager.application.ports.output.CustomerRepository;
import com.example.gasManager.core.domain.model.Customer;

public class SaveCustomerService implements SaveCustomerUseCase {

    private CustomerRepository customerRepository;

    public SaveCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
