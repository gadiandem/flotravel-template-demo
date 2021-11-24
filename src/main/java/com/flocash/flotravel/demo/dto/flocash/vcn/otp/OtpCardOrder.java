package com.flocash.flotravel.demo.dto.flocash.vcn.otp;

import lombok.Data;

@Data
public class OtpCardOrder {
    private OtpCard card;
    private String status;
    private String traceNumber;
    private String amount;
    private String currency;

}
