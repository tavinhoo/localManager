package com.example.gasManager.infrastructure.adapters.persistence.entity;

import jakarta.persistence.*;

import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getPhone_1() {
        return phone_1;
    }

    public void setPhone_1(String phone_1) {
        this.phone_1 = phone_1;
    }

    public String getPhone_2() {
        return phone_2;
    }

    public void setPhone_2(String phone_2) {
        this.phone_2 = phone_2;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(customerGender, that.customerGender) && Objects.equals(phone_1, that.phone_1) && Objects.equals(phone_2, that.phone_2) && Objects.equals(neighborhood, that.neighborhood) && Objects.equals(street, that.street) && Objects.equals(number, that.number) && Objects.equals(landmark, that.landmark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, customerGender, phone_1, phone_2, neighborhood, street, number, landmark);
    }
}