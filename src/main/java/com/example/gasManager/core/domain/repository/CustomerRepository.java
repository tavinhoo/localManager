package com.example.gasManager.core.domain.repository;
import com.example.gasManager.core.domain.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}
