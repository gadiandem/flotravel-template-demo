package com.flocash.flotravel.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class FlotravelConstant {

    public static final String FLOTRAVEL_TEST_DOMAIN = "https://flotravel-test.flocash.com";
    public static final String FLOTRAVEL_LIVE_DOMAIN = "https://flotravel.flocash.com";

    public static final String PACKAGE_SHOPPING_URL = "/api/packages/shopping";
    public static final String PACKAGE_HOTEL_ROOM_URL = "/api/packages/hotelRoom";
    public static final String PACKAGE_OPTIONAL_URL = "/api/packages/optional";
}
