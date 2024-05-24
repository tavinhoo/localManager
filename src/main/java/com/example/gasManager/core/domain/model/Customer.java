package com.example.gasManager.core.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private Long id;
    private String name;
    private String customerGender;
    private String phone1;
    private String phone2;
    private String neighborhood;
    private String street;
    private String number;
    private String landmark;

    private List<Order> orderList = new ArrayList<Order>();

    public Customer() {

    }

    public Customer(String name, String customerGender, String phone1, String phone2, String neighborhood, String street, String number, String landmark, List<Order> orderList) {
        this.name = name;
        this.customerGender = customerGender;
        this.phone1 = phone1;
        this.phone2 = phone2;
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

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(customerGender, customer.customerGender) && Objects.equals(phone1, customer.phone1) && Objects.equals(phone2, customer.phone2) && Objects.equals(neighborhood, customer.neighborhood) && Objects.equals(street, customer.street) && Objects.equals(number, customer.number) && Objects.equals(landmark, customer.landmark) && Objects.equals(orderList, customer.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, customerGender, phone1, phone2, neighborhood, street, number, landmark, orderList);
    }
}
