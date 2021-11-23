package com.flocash.flotravel.demo.dto.packages;

//import com.flocash.flotravel.dto.CustomerBookingInfo;
//import com.flocash.flotravel.dto.flocash.response.PayOption;
//import com.flocash.flotravel.dto.flocash.response.Payer;
//import com.flocash.flotravel.dto.flocash.response.Redirect;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderPackageRes {
    private String id;
    private String accountBooking;
    private boolean bookingForUser;
    private String userIsBooking;
    private String name;
    private String title;
    //    private Payer payer;
    private String packageId;
    private String packageAvailabilityId;
    private String hotelId;
    private int numberOfRoom;
    private List<String> roomIds;
    private String supplementId;
    private String tourId;
    private String transferId;
    private BigDecimal totalPrice;
    private BigDecimal tax;
    private String emailToNCT;

    private String bookingStatus;
//    private List<CustomerBookingInfo> customerBookingInfos;

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
//    private Payer payer;
//    private String bookingStatusDes;
//    private PayOption payOption;
//    private String approveCode;
//    private Redirect redirect;

}
