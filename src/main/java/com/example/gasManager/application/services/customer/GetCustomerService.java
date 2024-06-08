package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckIdExistsPort;
import com.example.gasManager.application.ports.input.customer.GetCustomerPort;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.core.exceptions.customer.CustomerNotFound;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerService implements GetCustomerPort {

    private CustomerPersistencePort customerPersistencePort;
    private CheckIdExistsPort checkIdExistsPort;

    public GetCustomerService(CustomerPersistencePort customerPersistencePort, CheckIdExistsPort checkIdExistsPort) {
        this.customerPersistencePort = customerPersistencePort;
        this.checkIdExistsPort = checkIdExistsPort;
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        if(!checkIdExistsPort.idExists(customerId)) {
            throw new CustomerNotFound("Customer not found");
        }
        return customerPersistencePort.findById(customerId).get();
    }
}
