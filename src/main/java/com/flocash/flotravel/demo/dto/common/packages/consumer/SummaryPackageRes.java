package com.flocash.flotravel.demo.dto.common.packages.consumer;

//import com.flocash.flotravel.domain.packages.provider.PackageTax;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SummaryPackageRes {
    private String id;
//    private PackageTax packageTax;
    private BigDecimal basePrice;
    private BigDecimal totalPrice;
    private String currency;
    private String startDate;
//    private int itemCount;
    private boolean available;
}
