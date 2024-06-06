package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CreateUniqueCustomerPort;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.input.customer.CreateCustomerPort;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements CreateCustomerPort {

    private final CustomerPersistencePort customerPersistencePort;

    public CreateCustomerService(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerPersistencePort.save(customer);
    }
}
