package com.invoicemang.invoicemangbackendapi.repository;

import com.invoicemang.invoicemangbackendapi.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
