package com.example.gasManager.usecase.customer;

public interface CheckIdAlreadyExists {
    Boolean customerExists(Long customerId);
}
