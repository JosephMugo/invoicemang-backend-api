package com.invoicemang.invoicemangbackendapi.dto;

import com.invoicemang.invoicemangbackendapi.model.Invoice;
import com.invoicemang.invoicemangbackendapi.model.Purchase;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class InvoiceDTO {

    @NotBlank(message = "Seller name required")
    private String sellerName;

    @NotBlank(message = "Seller address required")
    private String sellerAddress;

    @NotBlank(message = "Buyer name required")
    private String buyerName;

    @NotBlank(message = "Buyer address required")
    private String buyerAddress;

    @NotNull(message = "Date required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // converts string input into date object
    private Date date;

    @NotNull(message = "Due date required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dueDate;

    @NotNull
    @Size(min = 1, message = "minimum of one purchase required")
    private List<PurchaseDTO> purchases = new ArrayList<>();


    // convert invoice dto to invoice object
    public Invoice convertInvoiceDtoToInvoice() {
        Invoice invoice = new Invoice();
        invoice.setSellerName(this.sellerName);
        invoice.setSellerAddress(this.sellerAddress);
        invoice.setBuyerName(this.buyerName);
        invoice.setBuyerAddress(this.buyerAddress);
        invoice.setDate(this.date);
        invoice.setDueDate(this.dueDate);

        List<Purchase> purchaseList = new ArrayList<>();
        this.purchases.forEach(purchaseDTO -> {
            Purchase purchase = new Purchase();
            purchase.setDescription(purchaseDTO.getDescription());
            purchase.setQuantity(purchaseDTO.getQuantity());
            purchase.setCostPerUnit(purchaseDTO.getCostPerUnit());
            purchase.setInvoice(invoice);
            purchaseList.add(purchase);
        });
        invoice.setPurchases(purchaseList);
        return invoice;
    }


}
