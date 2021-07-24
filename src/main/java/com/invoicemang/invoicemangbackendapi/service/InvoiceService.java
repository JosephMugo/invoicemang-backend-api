package com.invoicemang.invoicemangbackendapi.service;

import com.invoicemang.invoicemangbackendapi.model.Invoice;
import com.invoicemang.invoicemangbackendapi.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// business logic
@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    // get all invoices
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoiceRepository.findAll().forEach(invoices::add);
        return invoices;
    }

    // get invoice by id
    public Invoice getInvoiceById(UUID id) {
        return invoiceRepository.findById(id).get();
    }

    // add invoice to database
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    // update invoice
    // only updatable fields are dueDate, sellerAddress, and buyerAddress
    public Invoice updateInvoice(UUID id, Invoice updatedInvoice) {
        Invoice invoice = invoiceRepository.findById(id).get();
        invoice.setDueDate(updatedInvoice.getDueDate());
        invoice.setSellerAddress(updatedInvoice.getSellerAddress());
        invoice.setBuyerAddress(updatedInvoice.getBuyerAddress());
        return invoiceRepository.save(invoice);
    }

    // delete invoice
    public void deleteInvoiceById(UUID id) {
        invoiceRepository.deleteById(id);
    }
}