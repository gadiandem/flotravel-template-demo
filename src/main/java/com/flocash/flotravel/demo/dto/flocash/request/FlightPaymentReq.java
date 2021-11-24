package com.flocash.flotravel.demo.dto.flocash.request;

import com.flocash.flotravel.dto.flight.create.order.request.CustomerInfo;
import com.flocash.flotravel.dto.flight.offerPrice.OfferItemSelected;
import com.flocash.flotravel.dto.flight.shopping.Travellers;
import com.flocash.flotravel.dto.flocash.BookingContact;
import com.flocash.flotravel.dto.flocash.PaymentInfo;
import lombok.Data;

import java.util.List;

@Data
public class FlightPaymentReq {
    //    private FlocashPaymentReq flocashRequest;
    private String offerPriceId;
    private String executionId;
    private List<OfferItemSelected> offerItems;
    private PaymentInfo paymentInfo;
//    private CreateOrderReq flightData;

//    private Passenger[] passengers;
    private List<CustomerInfo> customerInfos;
    private Travellers travellers;

    private BookingContact bookingContact;

    private String accountBooking;
    private boolean bookingForUser;
    private String userIsBooking;
    private boolean simulator;
}
