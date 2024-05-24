package com.example.gasManager.infrastructure.adapters.persistence.customer.entity;

import com.example.gasManager.core.domain.model.Order;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String customerGender;
    private String phone1;
    private String phone2;
    private String neighborhood;
    private String street;
    private String number;
    private String landmark;

    public CustomerEntity() {
    }

    public CustomerEntity(String name, String customerGender, String phone1, String phone2, String neighborhood, String street, String number, String landmark) {
        this.name = name;
        this.customerGender = customerGender;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.landmark = landmark;
    }

    public CustomerEntity(String name, String customerGender, String phone1, String neighborhood, String street, String number, String landmark) {
        this.name = name;
        this.customerGender = customerGender;
        this.phone1 = phone1;
        this.phone2 = null;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.landmark = landmark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}