package com.flocash.flotravel.demo.dto.flocash.request;

import java.io.Serializable;

public class Merchant implements Serializable {
    private String merchantAccount;

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }
}