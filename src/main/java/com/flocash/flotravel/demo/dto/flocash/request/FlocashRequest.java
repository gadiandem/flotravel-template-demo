package com.flocash.flotravel.demo.dto.flocash.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class FlocashRequest implements Serializable {
    private Order order;
    private Merchant merchant;
    private Payer payer;
    private PayOption payOption;
    private CardInfo cardInfo;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public PayOption getPayOption() {
        return payOption;
    }

    public void setPayOption(PayOption payOption) {
        this.payOption = payOption;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }
}
