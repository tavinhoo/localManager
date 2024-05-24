package com.example.gasManager.infrastructure.adapters.web;

import com.example.gasManager.application.services.customer.CreateCustomerService;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.exceptions.CustomerAlreadyExists;
import com.example.gasManager.infrastructure.adapters.persistence.customer.mapper.CustomerPersistenceMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CreateCustomerService createCustomerService;
    public final CustomerPersistenceMapper mapper;

    public CustomerController(CreateCustomerService createCustomerService, CustomerPersistenceMapper mapper) {
        this.createCustomerService = createCustomerService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(createCustomerService.createCustomer(customer));
        } catch (CustomerAlreadyExists e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
