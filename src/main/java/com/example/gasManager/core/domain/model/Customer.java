package com.example.gasManager.core.domain.model;

import com.example.gasManager.core.domain.enums.CustomerGender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private Long id;
    private String name;
    private Integer customerGender;
    private String phone_1;
    private String phone_2;
    private String neighborhood;
    private String street;
    private String number;
    private String landmark;

    private List<Order> orderList = new ArrayList<Order>();

    public Customer() {

    }

    public Customer(String name, CustomerGender customerGender, String phone_1, String phone_2, String neighborhood, String street, String number, String landmark, List<Order> orderList) {
        this.name = name;
        setCustomerGender(customerGender);
        this.phone_1 = phone_1;
        this.phone_2 = phone_2;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.landmark = landmark;
        this.orderList = orderList;
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

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(customerGender, customer.customerGender) && Objects.equals(phone_1, customer.phone_1) && Objects.equals(phone_2, customer.phone_2) && Objects.equals(neighborhood, customer.neighborhood) && Objects.equals(street, customer.street) && Objects.equals(number, customer.number) && Objects.equals(landmark, customer.landmark) && Objects.equals(orderList, customer.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, customerGender, phone_1, phone_2, neighborhood, street, number, landmark, orderList);
    }
}
