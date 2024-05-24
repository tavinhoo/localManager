package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckActiveOrdersPort;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.core.domain.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CheckActiveOrdersService implements CheckActiveOrdersPort  {

    private CustomerPersistencePort customerPersistencePort;

    public CheckActiveOrdersService(CustomerPersistencePort customerPersistencePort) {
        this.customerPersistencePort = customerPersistencePort;
    }

    @Override
    public Boolean customerHasActiveOrders(Long customerId) {
        Customer customer0 = customerPersistencePort.findById(customerId).get();
        if(!customer0.getOrderList().isEmpty()) {
            return true;
        }
        return false;
    }
}
