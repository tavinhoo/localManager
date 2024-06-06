package com.example.gasManager.infrastructure.adapters.web;

import com.example.gasManager.application.services.customer.CreateCustomerService;
import com.example.gasManager.application.services.customer.GetAllCustomersService;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.exceptions.CustomerAlreadyExists;
import com.example.gasManager.infrastructure.adapters.persistence.customer.entity.CustomerEntity;
import com.example.gasManager.infrastructure.adapters.persistence.customer.mapper.CustomerPersistenceMapper;
import com.example.gasManager.infrastructure.adapters.persistence.customer.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private CustomerPersistenceMapper customerPersistenceMapper;
    private final CreateCustomerService createCustomerService;
    private final GetAllCustomersService getAllCustomersService;

    private final CustomerRepository CUSTOMER_REPOSITORY;



    public CustomerController(CreateCustomerService createCustomerService, GetAllCustomersService getAllCustomersService, CustomerRepository customerRepository) {
        this.createCustomerService = createCustomerService;
        this.getAllCustomersService = getAllCustomersService;
        CUSTOMER_REPOSITORY = customerRepository;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer customer0 = createCustomerService.createCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(customer0);
        } catch (CustomerAlreadyExists e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(customerRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
