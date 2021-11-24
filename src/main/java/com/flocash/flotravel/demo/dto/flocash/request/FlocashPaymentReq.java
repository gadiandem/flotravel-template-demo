package com.flocash.flotravel.demo.dto.flocash.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FlocashPaymentReq {
    private BigDecimal amount;
    private BigDecimal itemPrice;
    private String itemName;
    private String currency;
//    private String orderId;
    private int quantity = 1;
    private Payer payer;
    private CardInfo cardInfo;
}
