package com.example.gasManager.application.services.customer;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerRepository;
import com.example.gasManager.application.ports.input.customer.SaveChangesUseCase;

public class SaveChangesService implements SaveChangesUseCase {

    private CustomerRepository customerRepository;

    @Override
    public void saveChanges(Customer customer) {
        customerRepository.save(customer);
    }
}
