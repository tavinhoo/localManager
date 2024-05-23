package com.example.gasManager.application.ports.output;
import com.example.gasManager.core.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    <S extends Customer> S save(S customer);
    Optional<Customer> findById(Long customerId);
    List<Customer> findAll();
    void delete(Customer customer);
    Optional<Customer> findByName(String customerName);
    Boolean existsByName(String customerName);
}