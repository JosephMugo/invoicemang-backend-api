package com.invoicemang.invoicemangbackendapi.service;

import com.invoicemang.invoicemangbackendapi.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAllInvoices();

    Invoice getInvoiceById(Integer id);

    Invoice addInvoice(Invoice invoice);

    Invoice updateInvoice(Integer id, Invoice updatedInvoice);

    void deleteInvoiceById(Integer id);
}
