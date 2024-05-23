package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckIdExistsUseCase;
import com.example.gasManager.application.ports.input.customer.GetCustomerUseCase;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerRepository;
import com.example.gasManager.core.exceptions.CustomerNotFound;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerService implements GetCustomerUseCase {

    private CustomerRepository customerRepository;
    private CheckIdExistsUseCase checkIdExistsUseCase;

    public GetCustomerService(CustomerRepository customerRepository, CheckIdExistsUseCase checkIdExistsUseCase) {
        this.customerRepository = customerRepository;
        this.checkIdExistsUseCase = checkIdExistsUseCase;
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        if(!checkIdExistsUseCase.idExists(customerId)) {
            throw new CustomerNotFound("Customer not found");
        }
        return customerRepository.findById(customerId).get();
    }
}
