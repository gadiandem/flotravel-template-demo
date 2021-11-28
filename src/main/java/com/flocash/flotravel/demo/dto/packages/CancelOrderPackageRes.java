package com.flocash.flotravel.demo.dto.packages;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.Data;

@Data
public class CancelOrderPackageRes extends BaseResponse {
    private OrderPackage result;
}
