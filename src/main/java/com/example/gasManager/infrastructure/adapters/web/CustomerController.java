package com.example.gasManager.infrastructure.adapters.web;

import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.application.services.customer.CreateCustomerService;
import com.example.gasManager.infrastructure.adapters.persistence.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private final CreateCustomerService createCustomerService;

    @Autowired
    private final CustomerPersistencePort customerPersistencePort;

    public CustomerController(CreateCustomerService createCustomerService, CustomerPersistencePort customerPersistencePort) {
        this.createCustomerService = createCustomerService;
        this.customerPersistencePort = customerPersistencePort;
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customer) {
       return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
