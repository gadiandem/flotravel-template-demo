package com.flocash.flotravel.demo.dto.flocash.response;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlocashCreateOrderRes extends BaseResponse {
    private Order result;
}
