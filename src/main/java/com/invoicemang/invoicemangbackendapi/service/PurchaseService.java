package com.invoicemang.invoicemangbackendapi.service;

import com.invoicemang.invoicemangbackendapi.model.Purchase;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getPurchases();

    void addPurchase(Purchase purchase);
}
