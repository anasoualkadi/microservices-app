package com.example.billingservice.models;

import com.example.billingservice.entities.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date billDate;

    private Long customerId;

    @OneToMany(mappedBy = "bill")
    private List<BillLine> billLines;

    @Transient //ignorer dans la creation de la bdd - sera récupérer par un autre microservices
    private Customer customer;


}
