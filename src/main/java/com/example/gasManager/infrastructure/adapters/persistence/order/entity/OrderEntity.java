package com.example.gasManager.infrastructure.adapters.persistence.order.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "orders")
public interface OrderEntity {


    private Long id;


}
