package com.example.gasManager.infrastructure.adapters.persistence.customer.repository;

import com.example.gasManager.infrastructure.adapters.persistence.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
