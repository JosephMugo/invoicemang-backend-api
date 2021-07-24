package com.invoicemang.invoicemangbackendapi.dto;

import com.invoicemang.invoicemangbackendapi.model.Invoice;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    @NotNull(message = "Due date required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dueDate;

    // convert invoice dto to invoice object
    public Invoice convertInvoiceDtoToInvoice() {

        Invoice invoice = new Invoice();
        invoice.setSellerName(this.sellerName);
        invoice.setSellerAddress(this.sellerAddress);
        invoice.setBuyerName(this.buyerName);
        invoice.setBuyerAddress(this.buyerAddress);
        invoice.setDate(this.date);
        invoice.setDueDate(this.dueDate);

        return invoice;
    }
}
