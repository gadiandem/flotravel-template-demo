package com.flocash.flotravel.demo.dto.common.packages.consumer;

import lombok.Data;

import java.util.List;

@Data
public class OptionalRes {
    private List<SupplementPackageRes> supplements;
    private List<TourPackageRes> tours;
    private List<TransferPackageRes> transfers;
}
