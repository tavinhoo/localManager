package com.example.gasManager.infrastructure.adapters.persistence;

import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.infrastructure.adapters.persistence.mapper.CustomerPersistenceMapper;
import com.example.gasManager.infrastructure.adapters.persistence.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerPersistenceAdapter implements CustomerPersistencePort {

    private final CustomerRepository repository;
    private final CustomerPersistenceMapper mapper;

    public CustomerPersistenceAdapter(CustomerRepository repository, CustomerRepository customerRepository1, CustomerPersistenceMapper customerPersistenceMapper, CustomerPersistenceMapper mapper) {
        this.repository = customerRepository1;
        this.mapper = mapper;
    }

    @Override
    public <S extends Customer> S save(S customer) {
        return (S) mapper.toCustomer(repository.save(mapper.toCustomerEntity(customer)));
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        return repository.findById(customerId).map(mapper::toCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return mapper.toCustomerList(repository.findAll());
    }

    @Override
    public void deleteById(Long customerId) {
        repository.deleteById(customerId);
    }

    @Override
    public Optional<Customer> findByName(String customerName) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByName(String customerName) {
        return null;
    }
}
