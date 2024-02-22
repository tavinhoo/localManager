package com.example.gasManager.model;

import com.example.gasManager.model.enums.CustomerGender;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_customer;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerGender customerGender;

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
    private List<Sale> wishList;
}
