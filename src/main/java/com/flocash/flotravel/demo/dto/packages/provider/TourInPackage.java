package com.flocash.flotravel.demo.dto.packages.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourInPackage  {
    private String id;
//    private String tourId;
    private String name;
    private String description;
    private String currency;
    private BigDecimal price;
    private String note;
}
