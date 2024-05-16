package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.usecase.customer.CheckPhoneAvailabilityUseCase;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.domain.model.Customer;

import java.util.List;

public class CheckPhoneAvailabilityUseCaseImpl implements CheckPhoneAvailabilityUseCase {

    private CustomerRepository customerRepository;
    public CheckPhoneAvailabilityUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Boolean phoneIsAvailable(String phoneNumber) {
        List<Customer> allCustomers = customerRepository.findAll();
        for (Customer customer : allCustomers) {
            if(customer.getPhone_1() == phoneNumber || customer.getPhone_2() == phoneNumber){
                return false;
            }
        }
        return true;
    }
}
