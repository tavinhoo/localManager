package com.example.gasManager.model;

import com.example.gasManager.model.enums.CustomerGender;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_customer")
public class Customer implements Serializable, Comparable<Customer> {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_customer;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer customerGender;

    @Column(nullable = false)
    private String phone_1;

    private String phone_2;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    private String reference;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long id_customer, String name, CustomerGender customerGender, String phone_1, String phone_2, String neighborhood, String street, String number, String reference) {
        this.id_customer = id_customer;
        this.name = name;
        setCustomerGender(customerGender);
        this.phone_1 = phone_1;
        this.phone_2 = phone_2;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.reference = reference;
    }

    public Long getId_customer() {
        return id_customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerGender getCustomerGender() throws IllegalAccessException {
        return CustomerGender.valueOf(customerGender);
    }

    public void setCustomerGender(CustomerGender customerGender) {
        if(customerGender != null) {
            this.customerGender = customerGender.getCode();
        }
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Order> getWishList() {
        return orderList;
    }

    @Override
    public int compareTo(Customer other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
