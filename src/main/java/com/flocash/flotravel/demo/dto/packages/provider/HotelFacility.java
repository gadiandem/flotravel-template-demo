package com.flocash.flotravel.demo.dto.packages.provider;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class HotelFacility {
    @Id
    private String id;
    private String name;
}
