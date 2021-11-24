package com.flocash.flotravel.demo.dto.flocash.response;

import java.io.Serializable;

public class ResultResponse implements Serializable {
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
