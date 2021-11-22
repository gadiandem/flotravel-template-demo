package com.flocash.flotravel.demo.dto.common.packages.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageShoppingItem {
    private String id;
    private String packageName;
    private String regionId;
    private String regionName;
    private String basicDescription;
    private int dayCount;
    private int nightCount;
    private LocalDate startDate;
    private String cityId;
    private String cityName;
    private String[][] itineraries;
    private String currency;
    private BigDecimal price;
    // hotel data
    private String hotelId;
    private String name;
    private String overview;
    private String hotelImage;
    private double starRate;
    private double latitude;
    private double longitude;
    private String additionalInfo;

//    private PackageTax tax;
    private List<String> roomImages;
    private List<String> highlightFacilities;
//    private BigDecimal minPrice;
//    private String currency;
    private List<String> inclusions;
    private List<String> exclusions;
//    private List<HotelFacility> fullFacilityDescriptions;
    private boolean breakfast;
    private String remark;
    private double discount;
    private Map<String, Integer> rooms;

    private List<String> supplements;
    private List<String> tours;
    private List<String> transfers;
}
