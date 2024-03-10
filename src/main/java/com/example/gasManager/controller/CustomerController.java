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
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Optional<Customer> customer0 = customerService.saveCustomer(customerDTO);

        if(customer0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CUSTOMER ALREADY EXISTS!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(customer0.get());
    }

    /* GET */
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable(value = "id") Long id) {
        Optional<Customer> customer0 = customerService.findCustomerById(id);
        if (customer0.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(customer0.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list0 = customerService.findAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(list0);
    }

    /* PUT */
    @PutMapping("/customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> customer0 = customerService.findCustomerById(id);
        if(customer0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CUSTOMER NOT FOUND!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customer0.get());
    }

    /* DELETE */
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable(value = "id") Long id) {
        Optional<Customer> customer0 = customerService.findCustomerById(id);
        if(customer0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CUSTOMER NOT FOUND!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("CUSTOMER DELETED");
    }
}
