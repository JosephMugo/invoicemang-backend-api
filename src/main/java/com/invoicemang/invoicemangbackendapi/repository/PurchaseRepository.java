package com.invoicemang.invoicemangbackendapi.repository;

import com.invoicemang.invoicemangbackendapi.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
}
