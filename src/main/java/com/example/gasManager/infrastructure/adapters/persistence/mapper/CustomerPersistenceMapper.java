package com.example.gasManager.infrastructure.adapters.persistence.mapper;

import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.infrastructure.adapters.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

    List<CustomerEntity> toCustomerEntityList(List<Customer> customers);

    List<Customer> toCustomerList(List<CustomerEntity> customerEntities);
}
