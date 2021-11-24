package com.flocash.flotravel.demo.dto.flocash.response;

import com.flocash.flotravel.demo.domain.common.Domain;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order extends Domain {
    private BigDecimal amount;
    private BigDecimal capturedAmount;
    private BigDecimal refundedAmount;
    private double orderDate;
    private String currency;
    private String currencyName;
    private String custom;
    private String item_name;
    private String item_price;
    private String quantity;
    private String orderId;
    private String tracking;
    private String traceNumber;
    private String partnerMessage;
    private String status;
    private String statusDesc;
    private String paymentChannel;
    private Payer payer;
    private PayOption payOption;
    private String approveCode;
    private Redirect redirect;
}
