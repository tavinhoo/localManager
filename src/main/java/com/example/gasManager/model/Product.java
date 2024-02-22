package com.example.gasManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_product;

    private String name;
    private Double unitary_value;

    @OneToMany(mappedBy = "product")
    private List<ProductSale> productSaleList;

}
