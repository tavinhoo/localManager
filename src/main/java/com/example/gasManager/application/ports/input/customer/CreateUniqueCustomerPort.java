package com.example.gasManager.application.ports.input.customer;

public interface CreateUniqueCustomerPort {
    Boolean customersExist(String customerName);
}
