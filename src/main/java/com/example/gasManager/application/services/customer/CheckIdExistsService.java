package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckIdExistsPort;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class CheckIdExistsService implements CheckIdExistsPort {

    private CustomerPersistencePort customerPersistencePort;

    public CheckIdExistsService(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public Boolean idExists(Long customerId) {
        if(customerPersistencePort.findById(customerId).isEmpty()) {
            return false;
        }
        return true;
    }
}
