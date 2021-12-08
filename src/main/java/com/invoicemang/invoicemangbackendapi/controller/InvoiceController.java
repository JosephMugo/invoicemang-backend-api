package com.invoicemang.invoicemangbackendapi.controller;

import com.invoicemang.invoicemangbackendapi.dto.InvoiceDTO;
import com.invoicemang.invoicemangbackendapi.model.Invoice;
import com.invoicemang.invoicemangbackendapi.model.Purchase;
import com.invoicemang.invoicemangbackendapi.service.InvoiceService;
import com.invoicemang.invoicemangbackendapi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private PurchaseService purchaseService;

    // handle request to get all invoices
    @GetMapping
    private List<Invoice> getInvoices() {
        return invoiceService.getAllInvoices();
    }

    // handle request to get invoice by id provided
    @GetMapping(path = "/{invoiceId}")
    private ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    // handle request to add new invoice
    @PostMapping
    private ResponseEntity<Invoice> addInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) {
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
        Invoice addedInvoice = invoiceService.addInvoice(invoice);
        return new ResponseEntity<>(addedInvoice, HttpStatus.OK);
    }

    // handle request to update invoice
    @PutMapping(path = "/{invoiceId}")
    private ResponseEntity<Invoice> updateInvoice(@PathVariable Integer invoiceId, @RequestBody InvoiceDTO invoiceDTO) {
        List<Purchase> emptyPlaceholderPurchaseList = new ArrayList<>();
        // list of purchase that passed in has no affect since purchase list of invoice does not get upgraded
        Invoice invoice = invoiceDTO.convertInvoiceDtoToInvoice(emptyPlaceholderPurchaseList);
        Invoice updatedInvoice = invoiceService.updateInvoice(invoiceId, invoice);
        return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
    }

    // delete invoice
    @DeleteMapping(path = "/{invoiceId}")
    private ResponseEntity<String> deleteInvoice(@PathVariable Integer invoiceId) {
        invoiceService.deleteInvoiceById(invoiceId);
        return new ResponseEntity<>("Invoice deleted", HttpStatus.OK);
    }
}
