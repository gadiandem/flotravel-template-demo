package com.flocash.flotravel.demo.dto.flocash;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class RefundData implements Serializable {
    private BigDecimal amount;
    private String currency;
    private String statement;
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
