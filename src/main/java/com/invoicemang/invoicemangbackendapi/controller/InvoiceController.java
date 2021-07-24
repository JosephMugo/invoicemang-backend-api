package com.invoicemang.invoicemangbackendapi.controller;

import com.invoicemang.invoicemangbackendapi.dto.InvoiceDTO;
import com.invoicemang.invoicemangbackendapi.model.Invoice;
import com.invoicemang.invoicemangbackendapi.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/invoices")
public class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
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
        Invoice invoice = invoiceDTO.convertInvoiceDtoToInvoice();
        return invoiceService.addInvoice(invoice);
    }

    // handle request to update invoice
    @PutMapping(path = "/{invoiceId}")
    private Invoice updateInvoice(@PathVariable UUID invoiceId, @RequestBody InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceDTO.convertInvoiceDtoToInvoice();
        return invoiceService.updateInvoice(invoiceId, invoice);
    }

    // delete invoice
    @DeleteMapping(path = "/{invoiceId}")
    private void deleteinvoice(@PathVariable UUID invoiceId) {
        invoiceService.deleteInvoiceById(invoiceId);
    }
}
