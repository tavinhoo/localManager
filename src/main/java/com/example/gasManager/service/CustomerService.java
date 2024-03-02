package com.example.gasManager.service;

import com.example.gasManager.DTO.CustomerDTO;
import com.example.gasManager.model.Customer;
import com.example.gasManager.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> findCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Customer> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        Collections.sort(customerList);
        return customerList;
    }

    public Optional<Customer> saveCustomer(CustomerDTO customerdto) {
        Customer customer0 = new Customer();
        BeanUtils.copyProperties(customerdto, customer0);
        return Optional.of(customerRepository.save(customer0));
    }

    public Optional<Customer> updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer0 = new Customer();
        if (customerRepository.existsById(id)) {
            customer0 = customerRepository.findById(id).get();
            BeanUtils.copyProperties(customerDTO, customer0);
            return Optional.of(customerRepository.save(customer0));
        }
        return Optional.empty();
    }

    public Optional<Customer> removeCustomer(Long id) {
        Optional<Customer> customer0 = customerRepository.findById(id);
        if (customer0.isEmpty()) {
            return Optional.empty();
        }
        customerRepository.deleteById(id);
        return Optional.of(customer0.get());
    }
}
