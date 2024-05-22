package com.example.gasManager.application.services.customer;

import com.example.gasManager.application.ports.input.customer.CheckActiveOrdersUseCase;
import com.example.gasManager.application.ports.input.customer.CheckIdExistsUseCase;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.application.ports.output.CustomerRepository;
import com.example.gasManager.application.ports.input.customer.DeleteCustomerUseCase;
import com.example.gasManager.application.ports.input.customer.GetCustomerUseCase;
import com.example.gasManager.core.exceptions.CustomerHasActiveOrders;
import com.example.gasManager.core.exceptions.CustomerNotFound;

public class DeleteCustomerService implements DeleteCustomerUseCase {

    private CustomerRepository customerRepository;
    private CheckIdExistsUseCase checkIdExists;
    private CheckActiveOrdersUseCase checkActiveOrdersUseCase;
    private GetCustomerUseCase getCustomerUseCase;

    public DeleteCustomerService(CustomerRepository customerRepository, CheckIdExistsUseCase checkIdExists, CheckActiveOrdersUseCase checkActiveOrdersUseCase, GetCustomerUseCase getCustomerUseCase) {
        this.customerRepository = customerRepository;
        this.checkIdExists = checkIdExists;
        this.checkActiveOrdersUseCase = checkActiveOrdersUseCase;
        this.getCustomerUseCase = getCustomerUseCase;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        if(!checkIdExists.idExists(customerId)) {
            throw new CustomerNotFound("Cadastro não encontrado!");
        }

        if(checkActiveOrdersUseCase.customerHasActiveOrders(customerId)) {
            throw new CustomerHasActiveOrders("O cliente tem ordens ativas!");
        }

        Customer customer0 = getCustomerUseCase.getCustomerById(customerId);
        customerRepository.delete(customer0);
    }
}
