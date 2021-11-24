package com.flocash.flotravel.demo.dto.flocash.vcn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VCNOrder {
    private String amount;
    private String currency;
}
