package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.application.usecases.customer.CheckActiveOrdersUseCase;
import com.example.gasManager.application.usecases.customer.CheckIdExists;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.exceptions.CustomerHasActiveOrders;
import com.example.gasManager.core.exceptions.CustomerNotFound;
import com.example.gasManager.usecase.customer.DeleteCustomerUseCase;

public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private CustomerRepository customerRepository;
    private CheckIdExists checkIdExists;
    private CheckActiveOrdersUseCase checkActiveOrdersUseCase;

    public DeleteCustomerUseCaseImpl(CustomerRepository customerRepository, CheckIdExists checkIdExists, CheckActiveOrdersUseCase checkActiveOrdersUseCase) {
        this.customerRepository = customerRepository;
        this.checkIdExists = checkIdExists;
        this.checkActiveOrdersUseCase = checkActiveOrdersUseCase;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        if(!checkIdExists.idExists(customerId)) {
            throw new CustomerNotFound("Cadastro não encontrado!");
        }

        if(checkActiveOrdersUseCase.customerHasActiveOrders(customerId)) {
            throw new CustomerHasActiveOrders("O cliente tem ordens ativas!");
        }

        Customer customer0 = customerRepository.findById(customerId);
        customerRepository.delete(customer0);
    }
}
