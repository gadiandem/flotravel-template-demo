package com.flocash.flotravel.demo.dto.flocash.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class HotelPaymentData implements Serializable {
    private FlocashRequest flocashRequest;
    private NuiteeData nuiteeData;
    private boolean simulator;
}
