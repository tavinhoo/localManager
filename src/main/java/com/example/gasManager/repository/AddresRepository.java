package com.example.gasManager.repository;

import com.example.gasManager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddresRepository extends JpaRepository<Address, Long> {
}
