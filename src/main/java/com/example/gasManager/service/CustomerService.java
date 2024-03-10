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

        boolean alreadyExits = false;

        for (Customer cust : customerRepository.findAll()) {
            if (customer0.getName().compareTo(cust.getName()) == 0) {
                alreadyExits = true;
                break;
            }
        }

        if (alreadyExits) {
            return Optional.empty();
        }
        return Optional.of(customerRepository.save(customer0));
    }

    public Optional<Customer> updateCustomer(Long id, CustomerDTO customerdto) {
        Optional<Customer> customer0 = customerRepository.findById(id);

        if (customer0.isEmpty()) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(customerdto, customer0.get());
        return Optional.of(customerRepository.save(customer0.get()));
    }

    public Optional<Object> removeCustomer(Long id) {
        Optional<Customer> customer0 = customerRepository.findById(id);

        if (customer0.isEmpty()) {
            return Optional.of("CUSTOMER NOT FOUND! ");
        }

        customerRepository.deleteById(id);
        return Optional.of("CUSTOMER HAS BEEN DELETED");
    }
}

