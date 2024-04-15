package com.example.gasManager.controller;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.exceptions.CustomerAlreadyExists;
import com.example.gasManager.exceptions.CustomerHasActiveOrders;
import com.example.gasManager.exceptions.CustomerNotFound;
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

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list0 = customerService.findAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(list0);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> getOneCustomer(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(customerService.findCustomerById(id).get());
        } catch (CustomerNotFound error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customerDTO));
        } catch (CustomerAlreadyExists error) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getMessage());
        }
    }

    /* PUT */
    @PutMapping("/customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> customer0 = customerService.updateCustomer(id, customerDTO);
        if(customer0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CUSTOMER NOT FOUND!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customer0.get());
    }

    /* DELETE */
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customerService.removeCustomer(id));
        } catch (CustomerNotFound error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        } catch (CustomerHasActiveOrders error) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getMessage());
        }
    }
}
