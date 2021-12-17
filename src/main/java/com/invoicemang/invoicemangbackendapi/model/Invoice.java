package com.invoicemang.invoicemangbackendapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Invoice", uniqueConstraints = {
        @UniqueConstraint(columnNames = "SELLER_NAME"),
        @UniqueConstraint(columnNames = "BUYER_NAME")
})
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer invoiceId;

    @Column(name = "SELLER_NAME")
    private String sellerName;

    @Column(name = "SELLER_ADDRESS")
    private String sellerAddress;

    @Column(name = "BUYER_NAME")
    private String buyerName;

    @Column(name = "BUYER_ADDRESS")
    private String buyerAddress;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "DUE_DATE")
    private Date dueDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Invoice_ID")
    private List<Purchase> purchases;
}
