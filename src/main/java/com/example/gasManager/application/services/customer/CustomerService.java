package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CustomerServicePort;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.exceptions.CustomerAlreadyExists;
import com.example.gasManager.core.exceptions.customer.*;

import java.util.List;
import java.util.Optional;

public class CustomerService implements CustomerServicePort {

    private CustomerPersistencePort customerPersistencePort;

    public CustomerService(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        if(customerPersistencePort.existsByName(customer.getName())) {
           throw new CustomerAlreadyExists("Já existe um cadastro com este nome!");
        }
        return customerPersistencePort.save(customer);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        if(findCustomerById(customerId).isEmpty()) {
            throw new CustomerNotFound("Cadastro não encontrado!");
        }
        customerPersistencePort.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        if(findCustomerById(customerId).isEmpty()) {
            throw new CustomerNotFound("Cadastro não encontrado!");
        }
        Customer customer0 = customerPersistencePort.findById(customerId).get();
        customer0.setName(customer.getName());
        customer0.setCustomerGender(customer.getCustomerGender());
        customer0.setPhone1(customer.getPhone1());
        customer0.setPhone2(customer.getPhone2());
        customer0.setNeighborhood(customer.getNeighborhood());
        customer0.setStreet(customer.getStreet());
        customer0.setNumber(customer.getNumber());
        customer0.setLandmark(customer.getLandmark());

        return customerPersistencePort.save(customer0);
    }

    @Override
    public Optional<Customer> findCustomerById(Long customerId) {
        return customerPersistencePort.findById(customerId);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return List.of();
    }
}
