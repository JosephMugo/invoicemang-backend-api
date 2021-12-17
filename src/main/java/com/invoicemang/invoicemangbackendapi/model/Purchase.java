package com.invoicemang.invoicemangbackendapi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PURCHASE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer invoideId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "COST_PER_UNIT")
    private BigDecimal costPerUnit;

    @ManyToOne
    private Invoice invoice;
}
