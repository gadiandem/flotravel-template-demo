package com.flocash.flotravel.demo.dto.mail;

import com.flocash.flotravel.demo.dto.flocash.response.Payer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class MailPackagesContent implements Serializable {
    private BigDecimal amount;
    private LocalDate orderDate;
    private String currency;
    private String currencyName;
    private String item_name;
    private String quantity;
    private String item_price;
    private String orderId;
    private String tracking;
    private String traceNumber;
    private LocalDate dateBooking;
    private String paymentChannel;
    private Payer payer;
    private String fromTime;
    private String toTime;
    private long bookingId;
    private String bookingStatus;
    private String bookingRemarks;
    private String token;
    private String refLink;

    private LocalDate startDate;
    private String reason;
    private LocalDate cancelDateReq;

    private String traceNumberRefund;
    private LocalDate cancelDateConfirm;

    private String bookingStatusDes;

//    private PackageInfo packageInfo;
//    private HotelPackage hotelPackage;
//    private List<HotelRoom> hotelRooms;
//    private List<Supplement> supplements;
//    private List<TourInPackage> tourInPackages;
//    private PackageTax tax;
//    private List<TransferInPackage> transferInPackages;
}
