package com.invoicemang.invoicemangbackendapi.controller;

import com.invoicemang.invoicemangbackendapi.model.Purchase;
import com.invoicemang.invoicemangbackendapi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/purchases")
@CrossOrigin(origins = "*")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchase> getPurchases() {
        return purchaseService.getPurchases();
    }
}
