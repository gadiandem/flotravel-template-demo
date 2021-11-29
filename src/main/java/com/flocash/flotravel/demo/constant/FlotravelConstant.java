package com.flocash.flotravel.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlotravelConstant {
    public static final String ACCOUNT_ID = "60379f09c860bf795b44c394";
    public static final String USER_BOOKING_LIST = "bookingList";
    public static final String AGENT_BOOKING_LIST = "agentBookingList";

    public static final String FLOTRAVEL_TEST_DOMAIN = "https://flotravel-test.flocash.com";
    public static final String FLOTRAVEL_LIVE_DOMAIN = "https://flotravel.flocash.com";

    // destination
    public static final String DESTINATION_URL = "/api/hotel/destinations";

    // elasticsearch destination
    public static final String DESTINATION_ELASTICSEARCH_URL = "https://flotravel.flocash.com/api/hotel/destinations/elasticsearch";

    public static final String PACKAGE_SHOPPING_URL = "/api/packages/shopping";
    public static final String PACKAGE_HOTEL_ROOM_URL = "/api/packages/hotelRoom";
    public static final String PACKAGE_OPTIONAL_URL = "/api/packages/optional";
    public static final String PACKAGE_SUMMARY_URL = "/api/packages/summary";
    public static final String REQUEST_VCN_URL = "/api/flocash/requestVCN/provider";
    public static final String PACKAGE_CREATE_URL = "/api/packages/packageOrder";
    public static final String PACKAGE_CANCEL_URL = "/api/packages/cancellation";
    public static final String BOOKING_LIST_URL = "/api/packages/historyBooking";
    public static final String BOOKING_DETAIL_URL = "/api/packages/historyDetail";
}
