package com.flocash.flotravel.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Constant {
    public static final String SUCCESS_CODE = "200";
    public static final String NO_RESULT_CODE = "400";

    public static final String SHOPPING_PACKAGE_SUCCESS = "Get Shopping Package Success";
    public static final String NO_RESULT_MASSAGE = "There is no result for this request";
}
