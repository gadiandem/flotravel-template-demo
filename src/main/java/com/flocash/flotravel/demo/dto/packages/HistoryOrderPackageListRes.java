package com.flocash.flotravel.demo.dto.packages;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class HistoryOrderPackageListRes {
    private String id;
    private String name;
    private String title;
    private BigDecimal totalPrice;
//    private PackageTax packageTax;
    private String bookingStatus;
    private String startDate;
    private LocalDateTime createDate;
    private String traceNumber;
    // flocash data
    private BigDecimal amount;
    private String currency;
    private String currencyName;
    private String custom;
    private String status;
//    private Payer payer;
}
