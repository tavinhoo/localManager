package com.example.gasManager.application.services.customer;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.input.customer.CheckIdExistsPort;
import com.example.gasManager.application.ports.input.customer.EditCustomerPort;
import com.example.gasManager.application.ports.input.customer.SaveChangesPort;
import com.example.gasManager.core.exceptions.CustomerNotFound;
import org.springframework.stereotype.Service;

@Service
public class EditCustomerService implements EditCustomerPort {

    private GetCustomerService getCustomerUseCase;
    private CheckIdExistsPort checkIdExists;
    private SaveChangesPort saveChangesUseCase;

    public EditCustomerService(GetCustomerService getCustomerUseCase, CheckIdExistsPort checkIdExistsPort, SaveChangesPort saveChangesUseCase) {
        this.getCustomerUseCase = getCustomerUseCase;
        this.checkIdExists = checkIdExistsPort;
        this.saveChangesUseCase = saveChangesUseCase;
    }

    @Override
    public void editCustomer(Long customerId, Customer customer) throws IllegalAccessException {
        if(!checkIdExists.idExists(customerId)) {
            throw new CustomerNotFound("Customer not found");
        }

        Customer customer0 = getCustomerUseCase.getCustomerById(customerId);

        customer0.setName(customer.getName());
        customer0.setCustomerGender(customer.getCustomerGender());
        customer0.setPhone_1(customer.getPhone_1());
        customer0.setPhone_2(customer.getPhone_2());
        customer0.setNeighborhood(customer.getNeighborhood());
        customer0.setStreet(customer.getStreet());
        customer0.setNumber(customer.getNumber());
        customer0.setLandmark(customer.getLandmark());

        saveChangesUseCase.saveChanges(customer0);
    }
}
