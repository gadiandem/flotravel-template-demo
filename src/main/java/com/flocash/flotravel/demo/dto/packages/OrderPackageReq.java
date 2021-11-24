package com.flocash.flotravel.demo.dto.packages;

import com.flocash.flotravel.demo.dto.common.CustomerBookingInfo;
import com.flocash.flotravel.demo.dto.flocash.BookingContact;
import com.flocash.flotravel.demo.dto.flocash.PaymentInfo;
import lombok.Data;

import java.util.List;

@Data
public class OrderPackageReq {
    private List<CustomerBookingInfo> customerBookingInfos;
    private PaymentInfo paymentInfo;
    private BookingContact bookingContact;
    private String accountBooking;
    private boolean bookingForUser;
    private String userIsBooking;
    private boolean demo = false;
    private PackagesBookingInfo packagesBookingInfo;
}
