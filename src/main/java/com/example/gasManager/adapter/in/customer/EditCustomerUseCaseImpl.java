package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.usecase.customer.CheckIdExists;
import com.example.gasManager.core.domain.usecase.customer.EditCustomerUseCase;
import com.example.gasManager.core.domain.usecase.customer.SaveChangesUseCase;
import com.example.gasManager.core.exceptions.CustomerNotFound;

public class EditCustomerUseCaseImpl implements EditCustomerUseCase {

    private GetCustomerUseCaseImpl getCustomerUseCase;
    private CheckIdExists checkIdExists;
    private SaveChangesUseCaseImpl saveChangesUseCase;

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
