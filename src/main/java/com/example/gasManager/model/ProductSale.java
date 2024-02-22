package com.example.gasManager.model;

import com.example.gasManager.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCT_SALE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProductSale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_orderItem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name="id_sale")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
