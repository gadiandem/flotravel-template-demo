package com.flocash.flotravel.demo.service;


import com.flocash.flotravel.demo.dto.common.packages.consumer.*;

public interface FlotravelDemoService {
    PackageShoppingRes shoppingPackage(PackageShoppingReq req);
    HotelRoomDetailRes getPackageHotelDetail(HotelRoomDetailReq req);
}
