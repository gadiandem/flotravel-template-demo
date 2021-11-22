package com.flocash.flotravel.demo.dto.common.packages.consumer;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HotelRoomDetailRes {
    private String id;
    private String hotelId;
    private String roomType;
    private String roomDescription;
    private String customerInformationPack;
    private int adultCount;
    private int childCount;
    private BigDecimal pricePerNight;
    private String currency;
    private double discount;
    private boolean breakfast;
}
