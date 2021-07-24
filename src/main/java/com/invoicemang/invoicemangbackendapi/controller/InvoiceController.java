package com.invoicemang.invoicemangbackendapi.controller;

import com.invoicemang.invoicemangbackendapi.dto.InvoiceDTO;
import com.invoicemang.invoicemangbackendapi.model.Invoice;
import com.invoicemang.invoicemangbackendapi.model.Purchase;
import com.invoicemang.invoicemangbackendapi.service.InvoiceService;
import com.invoicemang.invoicemangbackendapi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/invoices")
public class InvoiceController {

    private InvoiceService invoiceService;
    private PurchaseService purchaseService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, PurchaseService purchaseService) {
        this.invoiceService = invoiceService;
        this.purchaseService = purchaseService;
    }

    // handle request to get all invoices
    @GetMapping
    private List<Invoice> getInvoices() {
        return invoiceService.getAllInvoices();
    }

    // handle request to get invoice by id provided
    @GetMapping(path = "/{invoiceId}")
    private Invoice getInvoiceById(@PathVariable UUID invoiceId) {
        return invoiceService.getInvoiceById(invoiceId);
    }

    // handle request to add new invoice
    @PostMapping
    private Invoice addInvoice(@Valid  @RequestBody InvoiceDTO invoiceDTO) {
        List<Purchase> purchaseList = new ArrayList<>();
        invoiceDTO.getPurchases().forEach(purchaseDTO -> {
            Purchase purchase = new Purchase();
            purchase.setDescription(purchaseDTO.getDescription());
            purchase.setQuantity(purchaseDTO.getQuantity());
            purchase.setCostPerUnit(purchaseDTO.getCostPerUnit());
            purchaseList.add(purchase);
            purchaseService.addPurchase(purchase);
        });
        Invoice invoice = invoiceDTO.convertInvoiceDtoToInvoice(purchaseList);
        return invoiceService.addInvoice(invoice);
    }

    // handle request to update invoice
    @PutMapping(path = "/{invoiceId}")
    private Invoice updateInvoice(@PathVariable UUID invoiceId, @RequestBody InvoiceDTO invoiceDTO) {
        List<Purchase> emptyPlaceholderPurchaseList = new ArrayList<>();
        // list of purchase that passed in has no affect since purchase list of invoice does not get upgraded
        Invoice invoice = invoiceDTO.convertInvoiceDtoToInvoice(emptyPlaceholderPurchaseList);
        return invoiceService.updateInvoice(invoiceId, invoice);
    }

    // delete invoice
    @DeleteMapping(path = "/{invoiceId}")
    private void deleteinvoice(@PathVariable UUID invoiceId) {
        invoiceService.deleteInvoiceById(invoiceId);
    }
}
