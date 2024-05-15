package com.example.gasManager.core.exceptions;

public class PhoneNumberAlreadyRegistered extends RuntimeException {
    public PhoneNumberAlreadyRegistered(String phoneNumber) {
        super(phoneNumber + ": Already registered");
    }
}
