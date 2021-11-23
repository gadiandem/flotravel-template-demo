package com.flocash.flotravel.demo.service;


import com.flocash.flotravel.demo.dto.packages.*;

public interface FlotravelDemoService {
    PackageShoppingRes shoppingPackage(PackageShoppingReq req);
    HotelRoomDetailRes getPackageHotelDetail(HotelRoomDetailReq req);
    OptionalRes getOptionalList(OptionalReq req);
    SummaryPackageRes getSummary(SummaryPackageReq req);
}
