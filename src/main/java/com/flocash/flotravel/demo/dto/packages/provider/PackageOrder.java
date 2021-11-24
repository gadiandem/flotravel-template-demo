package com.flocash.flotravel.demo.dto.packages.provider;

import com.flocash.flotravel.demo.dto.flocash.response.Order;
import com.flocash.flotravel.demo.dto.packages.ItemPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageOrder extends Order {
    private String id;
    private String accountBooking;
    private boolean bookingForUser;
    private String userIsBooking;

    private String title;
    private String name;
//    private Payer payer;
    private String packageId;
    private String startDate;
    private String packageAvailabilityId;
    private String hotelId;
    private int numberOfRoom;
    private List<ItemPrice> rooms;
    private List<ItemPrice> supplements;
    private List<ItemPrice> tours;
    private List<ItemPrice> transfers;
    private BigDecimal totalPrice;
    private String emailToNCT;
    private boolean deleted = false;

    private String reason;
    private LocalDate cancelDateReq;
    private String payerWallet;

    private String traceNumberRefund;
    private LocalDate cancelDateConfirm;
    private Order refundOrder;

    private String bookingStatus;
    private String bookingStatusDes;
//    private List<CustomerBookingInfo> customerBookingInfos;

}
