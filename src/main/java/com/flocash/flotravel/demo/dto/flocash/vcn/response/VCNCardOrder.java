package com.flocash.flotravel.demo.dto.flocash.vcn.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VCNCardOrder {
    private String status;
    private String traceNumber;
    private String amount;
    private String currency;
}
