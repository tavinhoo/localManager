package com.example.gasManager.infrastructure.persistence;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.repository.CustomerRepository;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
