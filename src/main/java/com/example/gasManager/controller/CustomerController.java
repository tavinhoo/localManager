package com.example.gasManager.controller;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.service.CustomerService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
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

    /* POST */
    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customerDTO).get());
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable(value = "id") Long id) {
        Optional<Customer> customer0 = customerService.findCustomerById(id);
        if (customer0.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(customer0.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
