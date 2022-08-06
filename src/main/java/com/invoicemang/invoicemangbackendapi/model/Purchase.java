package com.invoicemang.invoicemangbackendapi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer purchaseId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "COST_PER_UNIT")
    private BigDecimal costPerUnit;

    @ManyToOne
    private Invoice invoice;
}
