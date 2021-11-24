package com.flocash.flotravel.demo.dto.flocash.vcn.response;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlocashVCNRes extends BaseResponse {
    private FlocashVCN result;
}
