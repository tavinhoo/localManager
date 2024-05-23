package com.example.gasManager.infrastructure.adapters.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer customerGender;
    private String phone_1;
    private String phone_2;
    private String neighborhood;
    private String street;
    private String number;
    private String landmark;

    public CustomerEntity() {
    }

    public CustomerEntity(String name, Integer customerGender, String phone_1, String neighborhood, String street, String number, String landmark) {
        this.name = name;
        this.customerGender = customerGender;
        this.phone_1 = phone_1;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.landmark = landmark;
    }

    public CustomerEntity(String name, Integer customerGender, String phone_1, String phone_2, String neighborhood, String street, String number, String landmark) {
        this.name = name;
        this.customerGender = customerGender;
        this.phone_1 = phone_1;
        this.phone_2 = phone_2;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.landmark = landmark;
    }
}