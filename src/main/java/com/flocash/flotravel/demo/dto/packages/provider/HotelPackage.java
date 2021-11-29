package com.flocash.flotravel.demo.dto.packages.provider;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class HotelPackage {
    @Id
    private String id;
    private String name;
    private String overview;
    private String hotelImage;
    private String cityId;
    private String cityName;
    private String regionId;
    private String regionName;

    private String hotelTaxId;
    private List<String> roomImages;
    private List<HotelFacility> fullFacilityDescriptions;
    private BigDecimal minPrice;
    private double starRate;
    private double latitude;
    private double longitude;
    private String additionalInfo;

    private boolean breakfast;
    private String remark;
    private double discount;
    private Map<String, Integer> rooms;
}
