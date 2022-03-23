package com.invoicemang.invoicemangbackendapi.service;

import com.invoicemang.invoicemangbackendapi.model.Purchase;
import com.invoicemang.invoicemangbackendapi.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public List<Purchase> getPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findAll().forEach(purchases::add);
        return purchases;
    }

    public void addPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

}
