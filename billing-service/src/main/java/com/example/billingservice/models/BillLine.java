package com.example.billingservice.models;

import com.example.billingservice.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //ne charge pas Bill a la lecture pour eviter une boucle infini
    private Bill bill;

    private int quantity;

    private double price;

    private double discount;

    @Transient
    private Product product;
}
