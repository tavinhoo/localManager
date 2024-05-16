package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.domain.usecase.customer.SaveChangesUseCase;

import java.util.List;

public class SaveChangesUseCaseImpl implements SaveChangesUseCase {

    private CustomerRepository customerRepository;

    @Override
    public void saveChanges(Customer customer) {
        customerRepository.save(customer);
    }
}
