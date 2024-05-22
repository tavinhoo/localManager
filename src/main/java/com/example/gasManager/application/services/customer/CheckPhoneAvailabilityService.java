package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckPhoneAvailabilityUseCase;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.input.customer.GetAllCustomersUseCase;

import java.util.List;

public class CheckPhoneAvailabilityService implements CheckPhoneAvailabilityUseCase {

    private GetAllCustomersUseCase getAllCustomers;

    public CheckPhoneAvailabilityService(GetAllCustomersUseCase getAllCustomers) {
            this.getAllCustomers = getAllCustomers;
    }

    @Override
    public Boolean phoneIsAvailable(String phoneNumber) {
        List<Customer> allCustomers = getAllCustomers.getAll();
        for (Customer customer : allCustomers) {
            if(customer.getPhone_1() == phoneNumber || customer.getPhone_2() == phoneNumber){
                return false;
            }
        }
        return true;
    }
}
