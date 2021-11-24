package com.flocash.flotravel.demo.dto.flocash.vcn.otp;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class OtpResponse extends BaseResponse {
    private OtpRes result;
}
