package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CreateUniqueCustomerPort;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.input.customer.CreateCustomerPort;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.core.exceptions.CustomerAlreadyExists;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements CreateCustomerPort {

    private final CustomerPersistencePort customerPersistencePort;
    private final CreateUniqueCustomerPort createUniqueCustomerPort;

    public CreateCustomerService(CustomerPersistencePort customerPersistencePort, CreateUniqueCustomerPort createUniqueCustomerPort) {
        this.customerPersistencePort = customerPersistencePort;
        this.createUniqueCustomerPort = createUniqueCustomerPort;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        if(createUniqueCustomerPort.customersExist(customer.getName())) {
            throw new CustomerAlreadyExists("Já existe um cadastro com este nome!");
        }
        return customerPersistencePort.save(customer);
    }
}
