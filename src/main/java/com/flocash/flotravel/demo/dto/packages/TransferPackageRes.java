package com.flocash.flotravel.demo.dto.packages;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferPackageRes {
    private String id;
    //    private String transferId;
    private String transferType;
    private boolean arrival;
    private boolean departure;
    private String currency;
    private BigDecimal amount;
    private String note;
}
