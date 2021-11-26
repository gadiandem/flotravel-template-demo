package com.flocash.flotravel.demo.dto.packages;

//import com.flocash.flotravel.domain.packages.provider.PackageTax;
import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SummaryPackageRes extends BaseResponse {
    private String id;
//    private PackageTax packageTax;
    private BigDecimal basePrice;
    private BigDecimal totalPrice;
    private String currency;
    private String startDate;
//    private int itemCount;
    private boolean available;
}
