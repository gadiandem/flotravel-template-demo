package com.flocash.flotravel.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlotravelConstant {

    public static final String FLOTRAVEL_TEST_DOMAIN = "https://flotravel-test.flocash.com";
    public static final String FLOTRAVEL_LIVE_DOMAIN = "https://flotravel.flocash.com";

    public static final String PROVIDER_WALLET_SANDBOX = "malcolm.lindop1@mobirr.com";
    public static final String PROVIDER_WALLET_PROD = "malcolm.lindop@new-concept.travel";

    // test env
    public static final String REQUEST_VCN_SANDBOX_URL = FLOTRAVEL_TEST_DOMAIN + "/rest/v2/vcns/byMerchant";
    public static final String REQUEST_VCN_LIVE_URL = FLOTRAVEL_LIVE_DOMAIN + "/rest/v2/vcns/byMerchant";

    public static final String FLOCASH_SANDBOX_MERCHANT_EMAIL = "flotravel@mobirr.com";
    public static final String API_USER_VCN_SANDBOX = "flotravel";
    public static final String API_PASS_VCN_SANDBOX = "Flo@1234travel";
    // api user
    public static final String API_USER_FLOCASH_SANDBOX = "flotravel";
    public static final String API_PASSWORD_FLOCASH_SANDBOX = "Flo@1234travel";
    // live env
    public static final String FLOCASH_LIVE_MERCHANT_EMAIL = "flotravel@mobirr.com";
    public static final String API_USER_FLOCASH_LIVE = "flotravel";
    public static final String API_PASS_FLOCASH_LIVE = "Flo@1234travel";

    // destination
    public static final String DESTINATION_URL = "/api/hotel/destinations";

    // elasticsearch destination
    public static final String DESTINATION_ELASTICSEARCH_URL = "https://flotravel.flocash.com/api/hotel/destinations/elasticsearch";

    public static final String PACKAGE_SHOPPING_URL = "/api/packages/shopping";
    public static final String PACKAGE_HOTEL_ROOM_URL = "/api/packages/hotelRoom";
    public static final String PACKAGE_OPTIONAL_URL = "/api/packages/optional";
}
