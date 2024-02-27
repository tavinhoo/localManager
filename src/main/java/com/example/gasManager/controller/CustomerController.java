package com.example.gasManager.controller;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gasManager.model.Customer;

import java.util.List;
import java.util.Optional;

@RestController

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getClientById(@PathVariable(value = "id") Long id) {
        Optional<Customer> customer0 = customerService.getOneCustomer(id);
        if(customer0.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(customer0.get());
        }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> listCostumers() {
       return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> inputCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        Optional<Customer> customerSaved = customerService.saveCustomer(customerDTO);
        if(customerSaved.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(customerSaved.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long id,
                                                 @RequestBody @Valid CustomerDTO customerDTO) {
       Optional<Customer> customer0 = customerService.updateCustomer(id, customerDTO);
       if(customer0.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.status(HttpStatus.OK).body(customer0.get());
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable(value = "id") Long id) {
        Optional<Customer> customer0 = customerService.removeCustomer(id);
        if(customer0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CUSTOMER NOT FOUND.");
        }
        return ResponseEntity.ok("CUSTOMER DELETED!");
    }
}
