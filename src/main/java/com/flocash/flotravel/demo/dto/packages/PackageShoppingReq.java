package com.flocash.flotravel.demo.dto.packages;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PackageShoppingReq {
    private String cityCode;
    private int minDay;
    private int maxDay;
    private LocalDate date;
}
