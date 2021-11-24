package com.flocash.flotravel.demo.dto.packages.provider;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PackageInfo  {
    private String id;
//    private String packageId;
    private String name;
    private String regionId;
    private String regionName;
    private String basicDescription;
    private int dayCount;
    private int nightCount;
    private String cityId;
    private String cityName;
    private String[][] itineraries;
    private List<String> inclusions;
    private List<String> exclusions;
    private String currency;
    private BigDecimal price;

    private String hotelId;
    private List<String> supplements;
    private List<String> tours;
    private List<String> transfers;
}
