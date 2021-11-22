package com.flocash.flotravel.demo.dto.common.packages.consumer;

import lombok.Data;

@Data
public class TourPackageRes {
    private String id;
    //    private String tourId;
    private String name;
    private String description;
    private String currency;
    private String price;
    private String note;
}
