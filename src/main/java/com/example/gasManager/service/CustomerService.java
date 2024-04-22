package com.example.gasManager.service;

import com.example.gasManager.model.DTO.CustomerDTO;
import com.example.gasManager.model.exceptions.CustomerAlreadyExists;
import com.example.gasManager.model.exceptions.CustomerHasActiveOrders;
import com.example.gasManager.model.exceptions.CustomerNotFound;
import com.example.gasManager.model.Customer;
import com.example.gasManager.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

    public Optional<Customer> findCustomerById(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFound("Cliente não encontrado!");
        }
        return customerRepository.findById(id);
    }

    public Optional<Customer> saveCustomer(CustomerDTO customerdto) {
        if(customerRepository.existsByName(customerdto.name())) {
            throw new CustomerAlreadyExists("Já existe um usuário com este nome!");
        }
        Customer customer0 = new Customer();
        BeanUtils.copyProperties(customerdto, customer0);
        return Optional.of(customerRepository.save(customer0));
    }

    public Optional<Customer> updateCustomer(Long id, CustomerDTO customerdto) {
        if(!customerRepository.existsById(id)) {
            throw new CustomerNotFound("Cadastro não encontrado ou não existe!");
        }
        Customer customer0 = customerRepository.findById(id).get();
        BeanUtils.copyProperties(customerdto, customer0);
        return Optional.of(customerRepository.save(customer0));
    }

    public Optional<Object> removeCustomer(Long id) {
        if(!customerRepository.existsById(id)) {
            throw new CustomerNotFound("Cadastro não encontrado!");
        }

        if(!customerRepository.findById(id).get().getWishList().isEmpty()) {
            throw new CustomerHasActiveOrders("Este cliente tem pedidos ativos!");
        }
        customerRepository.deleteById(id);
        return Optional.of("Cadastro deletado!");
    }
}

