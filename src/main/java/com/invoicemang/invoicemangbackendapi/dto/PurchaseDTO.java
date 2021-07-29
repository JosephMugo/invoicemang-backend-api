package com.invoicemang.invoicemangbackendapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class PurchaseDTO {

    @NotBlank(message = "Description required")
    private String description;

    @NotBlank(message = "Quantity required")
    private int quantity;

    @NotBlank(message = "Cost per unit required")
    private BigDecimal costPerUnit;

}
