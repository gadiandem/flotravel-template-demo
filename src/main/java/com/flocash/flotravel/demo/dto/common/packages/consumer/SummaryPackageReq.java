package com.flocash.flotravel.demo.dto.common.packages.consumer;

import lombok.Data;

import java.util.List;

@Data
public class SummaryPackageReq {
    private ItemPrice packageInfo;
    private String hotelId;
    private List<ItemPrice> hotelRooms;
    private List<ItemPrice> supplements;
    private List<ItemPrice> tours;
    private List<ItemPrice> transfers;
    private String startDate;
}
