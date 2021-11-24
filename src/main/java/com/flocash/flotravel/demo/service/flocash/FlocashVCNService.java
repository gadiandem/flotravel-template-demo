package com.flocash.flotravel.demo.service.flocash;

import com.flocash.flotravel.demo.dto.flocash.PaymentInfo;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpCardOrder;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpRes;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.VcnRequest;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCN;

public interface FlocashVCNService {
    FlocashVCN requestVCN(VcnRequest vcnRequest, String environment);
    OtpRes updateOtp(String traceNumber, String otp, String environment);
    PaymentInfo buildFlocashPaymentRequest(OtpCardOrder card, String email);
}
