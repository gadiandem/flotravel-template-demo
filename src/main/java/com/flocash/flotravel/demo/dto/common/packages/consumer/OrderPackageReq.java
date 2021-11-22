package com.flocash.flotravel.demo.dto.common.packages.consumer;

//import com.flocash.flotravel.dto.CustomerBookingInfo;
//import com.flocash.flotravel.dto.flocash.BookingContact;
//import com.flocash.flotravel.dto.flocash.PaymentInfo;
import lombok.Data;

import java.util.List;

@Data
public class OrderPackageReq {
//    private List<CustomerBookingInfo> customerBookingInfos;
//    private PaymentInfo paymentInfo;
//    private BookingContact bookingContact;
    private String accountBooking;
    private boolean bookingForUser;
    private String userIsBooking;
    private boolean demo = false;
    private PackagesBookingInfo packagesBookingInfo;
}
