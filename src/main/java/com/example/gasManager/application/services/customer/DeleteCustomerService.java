package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckActiveOrdersPort;
import com.example.gasManager.application.ports.input.customer.CheckIdExistsPort;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.application.ports.input.customer.DeleteCustomerPort;
import com.example.gasManager.application.ports.input.customer.GetCustomerPort;
import com.example.gasManager.core.exceptions.CustomerHasActiveOrders;
import com.example.gasManager.core.exceptions.CustomerNotFound;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerService implements DeleteCustomerPort {

    private CustomerPersistencePort customerPersistencePort;
    private CheckIdExistsPort checkIdExists;
    private CheckActiveOrdersPort checkActiveOrdersPort;
    private GetCustomerPort getCustomerPort;

    public DeleteCustomerService(CustomerPersistencePort customerPersistencePort, CheckIdExistsPort checkIdExists, CheckActiveOrdersPort checkActiveOrdersPort, GetCustomerPort getCustomerPort) {
        this.customerPersistencePort = customerPersistencePort;
        this.checkIdExists = checkIdExists;
        this.checkActiveOrdersPort = checkActiveOrdersPort;
        this.getCustomerPort = getCustomerPort;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        if(!checkIdExists.idExists(customerId)) {
            throw new CustomerNotFound("Cadastro não encontrado!");
        }

        if(checkActiveOrdersPort.customerHasActiveOrders(customerId)) {
            throw new CustomerHasActiveOrders("O cliente tem ordens ativas!");
        }

        Customer customer0 = getCustomerPort.getCustomerById(customerId);
        customerPersistencePort.delete(customer0);
    }
}
