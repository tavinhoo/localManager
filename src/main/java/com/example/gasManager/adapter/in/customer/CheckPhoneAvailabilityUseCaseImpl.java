package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.usecase.customer.CheckPhoneAvailabilityUseCase;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.usecase.customer.GetAllCustomersUseCase;

import java.util.List;

public class CheckPhoneAvailabilityUseCaseImpl implements CheckPhoneAvailabilityUseCase {

    private GetAllCustomersUseCase getAllCustomers;

    public CheckPhoneAvailabilityUseCaseImpl(GetAllCustomersUseCase getAllCustomers) {
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
