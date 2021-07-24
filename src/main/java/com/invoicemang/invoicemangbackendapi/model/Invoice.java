package com.invoicemang.invoicemangbackendapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue
    private UUID id;

    private String sellerName;
    private String sellerAddress;
    private String buyerName;
    private String buyerAddress;
    private Date date;
    private Date dueDate;

    public Invoice() {}

    public Invoice(String sellerName, String sellerAddress, String buyerName, String buyerAddress, Date date, Date dueDate) {
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.date = date;
        this.dueDate = dueDate;
    }

}
