package com.flocash.flotravel.demo.dto.flocash.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Order implements Serializable {
    private BigDecimal amount;
    private String orderId;
    private String item_name;
    private BigDecimal item_price;
    private int quantity;
    private String currency;
}
