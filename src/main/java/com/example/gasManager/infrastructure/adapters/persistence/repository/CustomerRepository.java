package com.example.gasManager.infrastructure.adapters.persistence.repository;

import com.example.gasManager.infrastructure.adapters.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
