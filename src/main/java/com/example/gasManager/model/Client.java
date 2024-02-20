package com.example.gasManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="CLIENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_client;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne(mappedBy = "client")
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<Telephone> phoneList;

}
