package com.example.gasManager.application.usecaseimpl;

import com.example.gasManager.application.gateway.customer.CreateCustomerGateway;
import com.example.gasManager.core.domain.Customer;
import com.example.gasManager.core.exceptions.CustomerAlreadyExists;
import com.example.gasManager.core.exceptions.PhoneNumberAlreadyRegistered;
import com.example.gasManager.usecase.Customer.CheckPhoneAvailabilityUseCase;
import com.example.gasManager.usecase.Customer.CreateCustomerUseCase;
import com.example.gasManager.usecase.Customer.CreateUniqueCustomerUseCase;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private CreateUniqueCustomerUseCase uniqueCustomerUseCase;
    private CheckPhoneAvailabilityUseCase checkPhoneAvailabilityUseCase;
    private CreateCustomerGateway createCustomerGateway;

    public CreateCustomerUseCaseImpl(CreateUniqueCustomerUseCase uniqueCustomerUseCase, CheckPhoneAvailabilityUseCase checkPhoneAvailabilityUseCase, CreateCustomerGateway createCustomerGateway) {
        this.uniqueCustomerUseCase = uniqueCustomerUseCase;
        this.checkPhoneAvailabilityUseCase = checkPhoneAvailabilityUseCase;
        this.createCustomerGateway = createCustomerGateway;
    }

    @Override
    public void createCustomer(Customer customer) {
        if(uniqueCustomerUseCase.customersExist(customer.getName())) {
            throw new CustomerAlreadyExists("Já existe um cadastro com este nome!");
        }

        if(!checkPhoneAvailabilityUseCase.phoneIsAvailable(customer.getPhone_1())) {
            throw new PhoneNumberAlreadyRegistered(customer.getPhone_1());
        }

        Customer savedCustomer = createCustomerGateway.createCustomer(customer);
    }
}
