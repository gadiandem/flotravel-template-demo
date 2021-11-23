package com.flocash.flotravel.demo.dto.packages;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HotelRoomDetailItem {
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
