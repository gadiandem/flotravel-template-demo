package com.flocash.flotravel.demo.dto.flocash.refund;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import com.flocash.flotravel.demo.dto.flocash.response.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundFLocash extends BaseResponse {
    private Order result;
}
