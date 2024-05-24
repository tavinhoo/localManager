package com.example.gasManager.infrastructure.adapters.web;

import com.example.gasManager.application.services.customer.CreateCustomerService;
import com.example.gasManager.application.services.customer.GetAllCustomersService;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.exceptions.CustomerAlreadyExists;
import com.example.gasManager.infrastructure.adapters.persistence.customer.mapper.CustomerPersistenceMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CreateCustomerService createCustomerService;
    private final GetAllCustomersService getAllCustomersService;


    public CustomerController(CreateCustomerService createCustomerService, GetAllCustomersService getAllCustomersService) {
        this.createCustomerService = createCustomerService;
        this.getAllCustomersService = getAllCustomersService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(createCustomerService.createCustomer(customer));
        } catch (CustomerAlreadyExists e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(getAllCustomersService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
