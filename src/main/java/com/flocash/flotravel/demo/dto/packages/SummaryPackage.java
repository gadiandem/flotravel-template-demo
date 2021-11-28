package com.flocash.flotravel.demo.dto.packages;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SummaryPackage {
    private String id;
    private BigDecimal basePrice;
    private BigDecimal totalPrice;
    private String currency;
    private String startDate;
//    private int itemCount;
    private boolean available;
}
