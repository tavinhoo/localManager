package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckPhoneAvailabilityPort;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.input.customer.GetAllCustomersPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckPhoneAvailabilityService implements CheckPhoneAvailabilityPort {

    private GetAllCustomersPort getAllCustomers;

    public CheckPhoneAvailabilityService(GetAllCustomersPort getAllCustomers) {
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
