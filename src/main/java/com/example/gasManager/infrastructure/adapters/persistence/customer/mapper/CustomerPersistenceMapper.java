package com.example.gasManager.infrastructure.adapters.persistence.customer.mapper;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.infrastructure.adapters.persistence.customer.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

    List<CustomerEntity> toCustomerEntityList(List<Customer> customers);

    List<Customer> toCustomerList(List<CustomerEntity> customerEntities);
}
