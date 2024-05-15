package com.example.gasManager.core.domain.repository;
import com.example.gasManager.core.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void save(Customer customer);
    Customer findById(Long customerId);
    List<Customer> findAll();
    void delete(Customer customer);
    Optional<Customer> findByName(String customerName);
    Boolean existsByName(String customerName);
}
