package com.example.gasManager.application.usecases.customer;

public interface CheckIdAlreadyExists {
    Boolean customerExists(Long customerId);
}
