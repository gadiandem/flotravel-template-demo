package com.flocash.flotravel.demo.dto.flocash;

import com.flocash.flotravel.demo.dto.flocash.request.CardInfo;
import com.flocash.flotravel.demo.dto.flocash.request.Payer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentInfo {
    private String name;
//    private String email;
    private BigDecimal price;
    private String currency;
    private CardInfo cardInfo;
    private Payer payer;
    // vcn payment
//    private String merchantAccount;
    private boolean vcnPayment;
    private String traceNumber;
    private String otpValue;
}
