package com.flocash.flotravel.demo.service;


import com.flocash.flotravel.demo.dto.flocash.RefundParameter;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.VcnRequest;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCNRes;
import com.flocash.flotravel.demo.dto.packages.*;
import com.flocash.flotravel.demo.dto.search.destination.DestinationRes;

import java.util.List;
import java.util.Map;

public interface FlotravelDemoService {
    DestinationRes destinationSearch(String keyword);
    DestinationRes destinationElasticSearch(String keyword);
    PackageShoppingRes shoppingPackage(PackageShoppingReq req);
    HotelRoomDetailRes getPackageHotelDetail(HotelRoomDetailReq req);
    OptionalRes getOptionalList(OptionalReq req);
    SummaryPackageRes getSummary(SummaryPackageReq req);
    FlocashVCNRes requestVcn(VcnRequest req);
    CreateOrderPackageRes createOrder(OrderPackageReq req);

    CancelOrderPackageRes cancelBooking(RefundParameter req);

    Map<String, List<HistoryOrderPackageListRes>> getBookingList(HistoryOrderPackageListReq req);
    HistoryOrderPackageDetailRes getBookingDetail(HistoryOrderPackageDetailReq req);

    void deleteBookingRecord(String packageBookingId);
}
