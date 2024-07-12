package com.example.gasManager.application.ports.input.customer;

import com.example.gasManager.core.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServicePort {

    Customer createCustomer(Customer customer);
    void deleteCustomerById(Long customerId);
    Customer updateCustomer(Long customerId, Customer customer);
    Optional<Customer> findCustomerById(Long customerId);
    List<Customer> findAllCustomers();
}
