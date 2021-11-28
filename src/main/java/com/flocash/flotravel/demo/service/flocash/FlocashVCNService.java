package com.flocash.flotravel.demo.service.flocash;

import com.flocash.flotravel.demo.dto.flocash.PaymentInfo;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpCardOrder;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpResponse;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.FlocashVCNReq;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.VcnRequest;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCNRes;

public interface FlocashVCNService {
    FlocashVCNRes requestVCN(VcnRequest vcnRequest);
    OtpResponse updateOtp(String traceNumber, String otp);
    PaymentInfo buildFlocashPaymentRequest(OtpCardOrder card, String email);
    FlocashVCNReq buildFlocashVcnRequest(VcnRequest vcnRequest, String merchantAccount);
}
