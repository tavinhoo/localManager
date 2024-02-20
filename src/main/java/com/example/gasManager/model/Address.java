package com.example.gasManager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_address;

    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String number;
    private String reference;

    @OneToOne
    @JoinColumn(name= "id_client", nullable = false)
    private Client client;

}
