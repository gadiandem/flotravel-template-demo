package com.flocash.flotravel.demo.service.provider;

import com.flocash.flotravel.demo.dto.packages.provider.PackageInfo;
import com.flocash.flotravel.demo.dto.packages.provider.Supplement;
import com.flocash.flotravel.demo.dto.packages.provider.TourInPackage;
import com.flocash.flotravel.demo.dto.packages.provider.TransferInPackage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PackageProviderService {
    public PackageInfo getPackageInfo(String packageInfoId){
        return null;
    }

    public Supplement getSupplement(String supplementId){
        return null;
    }

    public TourInPackage getTourPackage(String tourPackageId){
        return null;
    }

    public TransferInPackage getTransfer(String transferId){
        return null;
    }

}
