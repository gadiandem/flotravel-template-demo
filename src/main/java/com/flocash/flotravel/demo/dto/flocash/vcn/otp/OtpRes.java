package com.flocash.flotravel.demo.dto.flocash.vcn.otp;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("otpRes")
public class OtpRes {
    private OtpCardOrder cardOrder;
}
