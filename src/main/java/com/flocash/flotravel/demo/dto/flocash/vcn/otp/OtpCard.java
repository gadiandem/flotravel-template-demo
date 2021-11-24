package com.flocash.flotravel.demo.dto.flocash.vcn.otp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OtpCard {
    private String id;
    private String realPan;
    private String pan;
    private String cvv;
    private String currency;
    private String expireMonth;
    private String expireYear;
    private BigDecimal balance;
    private String token;
    private String status;
    private BillingAddress billingAddress;
}
