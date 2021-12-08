package com.invoicemang.invoicemangbackendapi.controller;

import com.invoicemang.invoicemangbackendapi.dto.InvoiceDTO;
import com.invoicemang.invoicemangbackendapi.model.Invoice;
import com.invoicemang.invoicemangbackendapi.model.Purchase;
import com.invoicemang.invoicemangbackendapi.service.InvoiceServiceImpl;
import com.invoicemang.invoicemangbackendapi.service.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {

    @Autowired
    private InvoiceServiceImpl invoiceServiceImpl;

    @Autowired
    private PurchaseServiceImpl purchaseServiceImpl;
    
    // handle request to get all invoices
    @GetMapping
    private List<Invoice> getInvoices() {
        return invoiceServiceImpl.getAllInvoices();
    }

    // handle request to get invoice by id provided
    @GetMapping(path = "/{invoiceId}")
    private Invoice getInvoiceById(@PathVariable Integer invoiceId) {
        return invoiceServiceImpl.getInvoiceById(invoiceId);
    }

    // handle request to add new invoice
    @PostMapping
    private Invoice addInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {
        List<Purchase> purchaseList = new ArrayList<>();
        invoiceDTO.getPurchases().forEach(purchaseDTO -> {
            Purchase purchase = new Purchase();
            purchase.setDescription(purchaseDTO.getDescription());
            purchase.setQuantity(purchaseDTO.getQuantity());
            purchase.setCostPerUnit(purchaseDTO.getCostPerUnit());
            purchaseList.add(purchase);
            purchaseServiceImpl.addPurchase(purchase);
        });
        Invoice invoice = invoiceDTO.convertInvoiceDtoToInvoice(purchaseList);
        return invoiceServiceImpl.addInvoice(invoice);
    }

    // handle request to update invoice
    @PutMapping(path = "/{invoiceId}")
    private Invoice updateInvoice(@PathVariable Integer invoiceId, @RequestBody InvoiceDTO invoiceDTO) {
        List<Purchase> emptyPlaceholderPurchaseList = new ArrayList<>();
        // list of purchase that passed in has no affect since purchase list of invoice does not get upgraded
        Invoice invoice = invoiceDTO.convertInvoiceDtoToInvoice(emptyPlaceholderPurchaseList);
        return invoiceServiceImpl.updateInvoice(invoiceId, invoice);
    }

    // delete invoice
    @DeleteMapping(path = "/{invoiceId}")
    private void deleteInvoice(@PathVariable Integer invoiceId) {
        invoiceServiceImpl.deleteInvoiceById(invoiceId);
    }
}
