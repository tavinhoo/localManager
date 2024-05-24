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
    private CheckActiveOrdersPort checkActiveOrdersPort;
    private GetCustomerPort getCustomerPort;
    private CheckIdExistsPort checkIdExistsPort;

    public DeleteCustomerService(CustomerPersistencePort customerPersistencePort, CheckActiveOrdersPort checkActiveOrdersPort, GetCustomerPort getCustomerPort, CheckIdExistsPort checkIdExistsPort) {
        this.customerPersistencePort = customerPersistencePort;
        this.checkActiveOrdersPort = checkActiveOrdersPort;
        this.getCustomerPort = getCustomerPort;
        this.checkIdExistsPort = checkIdExistsPort;
    }


    @Override
    public void deleteCustomerById(Long customerId) {
        if(!checkIdExistsPort.idExists(customerId)) {
            throw new CustomerNotFound("Cadastro não encontrado!");
        }

        if(checkActiveOrdersPort.customerHasActiveOrders(customerId)) {
            throw new CustomerHasActiveOrders("O cliente tem ordens ativas!");
        }
        customerPersistencePort.deleteById(customerId);
    }
}
