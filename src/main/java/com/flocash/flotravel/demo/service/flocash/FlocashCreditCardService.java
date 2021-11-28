package com.flocash.flotravel.demo.service.flocash;

import com.flocash.flotravel.demo.dto.flocash.PaymentInfo;
import com.flocash.flotravel.demo.dto.flocash.RefundData;
import com.flocash.flotravel.demo.dto.flocash.refund.RefundFLocash;
import com.flocash.flotravel.demo.dto.flocash.request.FlocashRequest;
import com.flocash.flotravel.demo.dto.flocash.response.FlocashCreateOrderRes;
import com.flocash.flotravel.demo.dto.flocash.response.Order;
import com.flocash.flotravel.demo.dto.packages.provider.PackageOrder;

public interface FlocashCreditCardService {

    FlocashCreateOrderRes paymentAndBooking(FlocashRequest data);
    RefundFLocash refundFlocashProvider(RefundData refundData, String traceNumber);

    FlocashRequest buildFlocashPaymentRequest(PaymentInfo paymentInfo, String merchant);
}
