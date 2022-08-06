package com.invoicemang.invoicemangbackendapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase_id")
    private Integer purchaseId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "COST_PER_UNIT")
    private BigDecimal costPerUnit;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    @JsonIgnore
    private Invoice invoice;
}
