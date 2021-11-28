package com.flocash.flotravel.demo.dto.flocash.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultResponse {
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
