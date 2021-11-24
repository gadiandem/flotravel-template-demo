package com.flocash.flotravel.demo.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantPayment {
    private boolean generateCard;
    private String vcnAgentAccount;
    private String apiAccount;
    private String apiPassword;
}
