package com.invoicemang.invoicemangbackendapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue
    private UUID id;

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
