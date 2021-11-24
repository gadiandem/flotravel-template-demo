package com.flocash.flotravel.demo.dto.flocash.vcn.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlocashVCNReq {
    private VCNOrder order;
    private VCNMerchant merchant;
    private VCNCardInfo cardInfo;
    private VCNAgent vcnAgent;
}
