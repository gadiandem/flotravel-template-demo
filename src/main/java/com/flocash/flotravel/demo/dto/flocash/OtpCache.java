package com.flocash.flotravel.demo.dto.flocash;

import com.flocash.flotravel.demo.domain.common.Domain;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpCardOrder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "otpRes")
public class OtpCache extends Domain {
    @Id
    private String id;
    private OtpCardOrder cardOrder;
}
