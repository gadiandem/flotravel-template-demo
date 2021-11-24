package com.flocash.flotravel.demo.dto.packages.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplement  {
    private String id;
    private String name;
    private String shortDescription;
    private String description;
    private String currency;
    private BigDecimal price;
    private String note;
}
