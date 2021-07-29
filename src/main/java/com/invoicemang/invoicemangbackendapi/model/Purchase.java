package com.invoicemang.invoicemangbackendapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;
    private int quantity;
    private BigDecimal costPerUnit;

    public Purchase() {}

    public Purchase(String description, int quantity, BigDecimal costPerUnit) {
        this.description = description;
        this.quantity = quantity;
        this.costPerUnit = costPerUnit;
    }
}
