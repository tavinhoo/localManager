package com.example.gasManager.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sale;

    @Column(nullable = false)
    private Double totalValue;

    @Column(nullable = false)
    private Instant saleDate;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer client;

    public Order() {
    }

    public Order(Double totalValue, Instant saleDate, Customer client) {
        this.totalValue = totalValue;
        this.saleDate = saleDate;
        this.client = client;
    }

    public Long getId_sale() {
        return id_sale;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Instant getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Instant saleDate) {
        this.saleDate = saleDate;
    }

    public Customer getClient() {
        return client;
    }

    public void setClient(Customer client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id_sale, order.id_sale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_sale);
    }
}
