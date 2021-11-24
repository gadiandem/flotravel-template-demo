package com.flocash.flotravel.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Constant {
    public static final String SUCCESS_CODE = "200";
    public static final String NO_RESULT_CODE = "400";
    public static final String BAD_REQUEST = "400";
    public static final String SERVER_ERROR = "500";

    public static final String LIVE_ENV = "live";


    public static final String GET_DESTINATION_SUCCESS = "Get Destination Success";
    public static final String SHOPPING_PACKAGE_SUCCESS = "Get Shopping Package Success";
    public static final String PACKAGE_DETAIL_SUCCESS = "Get Detail Package Success";
    public static final String GET_OPTIONAL_SUCCESS = "Get Optional Success";

    public static final String NO_RESULT_MASSAGE = "There is no result for this request";
    public static final String PACKAGE_NOT_AVAILABLE_MASSAGE = "This is package not available";
}
