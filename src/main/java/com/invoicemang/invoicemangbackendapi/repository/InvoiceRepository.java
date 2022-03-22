package com.invoicemang.invoicemangbackendapi.repository;

import com.invoicemang.invoicemangbackendapi.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
