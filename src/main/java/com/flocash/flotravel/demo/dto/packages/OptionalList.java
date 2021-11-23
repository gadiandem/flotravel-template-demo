package com.flocash.flotravel.demo.dto.packages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionalList {
    private List<SupplementPackageRes> supplements;
    private List<TourPackageRes> tours;
    private List<TransferPackageRes> transfers;
}
