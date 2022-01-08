package com.invoicemang.invoicemangbackendapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String sellerName;
    private String sellerAddress;
    private String buyerName;
    private String buyerAddress;
    private Date date;
    private Date dueDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Purchase> purchases;

    public Invoice() {
    }

    public Invoice(String sellerName, String sellerAddress, String buyerName, String buyerAddress, Date date, Date dueDate, List<Purchase> purchases) {
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.date = date;
        this.dueDate = dueDate;
        this.purchases = purchases;
    }

}
