package com.flocash.flotravel.demo.dto.flocash.vcn.request;

import com.flocash.flotravel.demo.dto.common.MerchantPayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VcnRequest {
//    private String accountId;
    private BigDecimal price;
    private String currency;
    private MerchantPayment merchantPayment;

}
