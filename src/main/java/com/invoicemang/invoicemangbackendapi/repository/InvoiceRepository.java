package com.invoicemang.invoicemangbackendapi.repository;

import com.invoicemang.invoicemangbackendapi.model.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
}
