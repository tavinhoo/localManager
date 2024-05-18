package com.example.gasManager.adapter.in.customer;

import com.example.gasManager.core.domain.usecase.customer.CheckActiveOrdersUseCase;
import com.example.gasManager.core.domain.usecase.customer.CheckIdExists;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.core.domain.repository.CustomerRepository;
import com.example.gasManager.core.domain.usecase.customer.DeleteCustomerUseCase;
import com.example.gasManager.core.domain.usecase.customer.GetCustomerUseCase;
import com.example.gasManager.core.exceptions.CustomerHasActiveOrders;
import com.example.gasManager.core.exceptions.CustomerNotFound;

public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private CustomerRepository customerRepository;
    private CheckIdExists checkIdExists;
    private CheckActiveOrdersUseCase checkActiveOrdersUseCase;
    private GetCustomerUseCase getCustomerUseCase;

    public DeleteCustomerUseCaseImpl(CustomerRepository customerRepository, CheckIdExists checkIdExists, CheckActiveOrdersUseCase checkActiveOrdersUseCase, GetCustomerUseCase getCustomerUseCase) {
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
