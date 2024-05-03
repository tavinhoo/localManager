package com.example.gasManager.application.usecaseimpl;

import com.example.gasManager.application.gateway.customer.DeleteCustomerGateway;
import com.example.gasManager.core.exceptions.CustomerHasActiveOrders;
import com.example.gasManager.core.exceptions.CustomerNotFound;
import com.example.gasManager.usecase.Customer.CheckActiveOrdersUseCase;
import com.example.gasManager.usecase.Customer.CheckIfCustomerExistsUseCase;
import com.example.gasManager.usecase.Customer.DeleteCustomerUseCase;

public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private CheckActiveOrdersUseCase checkActiveOrdersUseCase;
    private CheckIfCustomerExistsUseCase checkIfCustomerExistsUseCase;
    private DeleteCustomerGateway  deleteCustomerGateway;

    public DeleteCustomerUseCaseImpl(CheckActiveOrdersUseCase checkActiveOrdersUseCase, DeleteCustomerGateway deleteCustomerGateway, CheckIfCustomerExistsUseCase checkIfCustomerExistsUseCase) {
        this.checkActiveOrdersUseCase = checkActiveOrdersUseCase;
        this.checkIfCustomerExistsUseCase = checkIfCustomerExistsUseCase;
        this.deleteCustomerGateway = deleteCustomerGateway;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        if(checkActiveOrdersUseCase.customerHasActiveOrders(customerId)) {
            throw new CustomerHasActiveOrders("Cliente tem pedidos ativos!");
        }
        if(!checkIfCustomerExistsUseCase.customerExists(customerId)) {
            throw new CustomerNotFound("Este cliente não existe!");
        }

        deleteCustomerGateway.deleteCustomer(customerId);
    }
}
