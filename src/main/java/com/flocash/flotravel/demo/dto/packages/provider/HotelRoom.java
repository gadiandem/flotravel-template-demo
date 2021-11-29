package com.flocash.flotravel.demo.dto.packages.provider;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class HotelRoom  {
    @Id
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
