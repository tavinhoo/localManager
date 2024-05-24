package com.example.gasManager.application.services.customer;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.application.ports.input.customer.SaveChangesPort;
import org.springframework.stereotype.Service;

@Service
public class SaveChangesService implements SaveChangesPort {

    private final CustomerPersistencePort customerPersistencePort;

    public SaveChangesService(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public void saveChanges(Customer customer) {
        customerPersistencePort.save(customer);
    }




}
