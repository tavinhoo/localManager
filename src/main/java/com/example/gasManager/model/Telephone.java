package com.example.gasManager.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="TELEPHONE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_telephone;

    @Column(nullable = false)
    private String telephone_type;

    @Column(unique = true, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name= "id_client", nullable = false)
    private Client client;
}
