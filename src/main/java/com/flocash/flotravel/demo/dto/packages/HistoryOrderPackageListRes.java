package com.flocash.flotravel.demo.dto.packages;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class HistoryOrderPackageListRes extends BaseResponse {
    private HistoryOrderPackageList result;
}
