package com.flocash.flotravel.demo.dto.packages;


import com.flocash.flotravel.demo.dto.flocash.response.PayOption;
import com.flocash.flotravel.demo.dto.flocash.response.Payer;
import com.flocash.flotravel.demo.dto.flocash.response.Redirect;
import com.flocash.flotravel.demo.dto.packages.provider.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class HistoryOrderPackageDetail {
    private String id;
    private String accountBooking;
    private boolean bookingForUser;
    private String userIsBooking;
    private String name;
    private String title;
    private PackageInfo packageInfo;

    private HotelPackage hotelPackage;
    private int numberOfRoom;
    private List<HotelRoom> rooms;
    private List<Supplement> supplements;
    private List<TourInPackage> tourInPackages;
    private List<TransferInPackage> transferInPackages;
    private BigDecimal totalPrice;
    private String emailToNCT;

    private String bookingStatus;
//    private List<CustomerBookingInfo> customerBookingInfos;

    private LocalDateTime createDate;
    private String startDate;
    // flocash data
    private BigDecimal amount;
    private BigDecimal capturedAmount;
    private BigDecimal refundedAmount;
    private double orderDate;
    private String currency;
    private String currencyName;
    private String custom;
    private String item_name;
    private String item_price;
    private String quantity;
    private String orderId;
    private String tracking;
    private String traceNumber;
    private String partnerMessage;
    private String status;
    private String statusDesc;
    private String paymentChannel;
    private Payer payer;
    private PayOption payOption;
    private String approveCode;
    private Redirect redirect;
}
