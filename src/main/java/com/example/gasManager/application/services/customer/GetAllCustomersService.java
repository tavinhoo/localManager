package com.example.gasManager.application.services.customer;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.application.ports.input.customer.GetAllCustomersPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCustomersService implements GetAllCustomersPort {

    private CustomerPersistencePort customerPersistencePort;

    public GetAllCustomersService(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public List<Customer> getAll() {
        return customerPersistencePort.findAll();
    }
}
