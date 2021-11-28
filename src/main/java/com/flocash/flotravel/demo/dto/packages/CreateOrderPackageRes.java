package com.flocash.flotravel.demo.dto.packages;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import com.flocash.flotravel.demo.dto.common.CustomerBookingInfo;
import com.flocash.flotravel.demo.dto.flocash.BookingContact;
import com.flocash.flotravel.demo.dto.flocash.PaymentInfo;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderPackageRes extends BaseResponse {
    private OrderPackage result;
}
