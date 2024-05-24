package com.example.gasManager.application.services.customer;


import com.example.gasManager.application.ports.input.customer.CreateUniqueCustomerPort;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class CreateUniqueCustomerService implements CreateUniqueCustomerPort {

    private final CustomerPersistencePort customerPersistencePort;

    public CreateUniqueCustomerService(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public Boolean customersExist(String customerName) {
        return customerPersistencePort.existsByName(customerName);
    }
}
