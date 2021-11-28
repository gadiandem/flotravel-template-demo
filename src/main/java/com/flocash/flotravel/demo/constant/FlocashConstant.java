package com.flocash.flotravel.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlocashConstant {
    public static final String FLOCASH_TEST_DOMAIN = "https://sandbox.flocash.com";
    public static final String FLOCASH_LIVE_DOMAIN = "https://fcms.flocash.com";

    public static final String PROVIDER_WALLET_SANDBOX = "malcolm.lindop1@mobirr.com";
    public static final String PROVIDER_WALLET_PROD = "malcolm.lindop@new-concept.travel";

    // test env
    public static final String REQUEST_VCN_SANDBOX_URL = FLOCASH_TEST_DOMAIN + "/rest/v2/vcns/byMerchant";
    public static final String CREATE_ORDER_SANDBOX_URL = FLOCASH_TEST_DOMAIN + "/rest/v2/orders";

    // live env
    public static final String FLOCASH_LIVE_MERCHANT_EMAIL = "flotravel@mobirr.com";
    public static final String REQUEST_VCN_LIVE_URL = FLOCASH_LIVE_DOMAIN + "/rest/v2/vcns/byMerchant";
    public static final String CREATE_ORDER_LIVE_URL = FLOCASH_LIVE_DOMAIN + "/rest/v2/orders";

    public static final String FLOCASH_SANDBOX_MERCHANT_EMAIL = "flotravel@mobirr.com";
    public static final String API_USER_VCN_SANDBOX = "flotravel";
    public static final String API_PASS_VCN_SANDBOX = "Flo@1234travel";


    // api user
    public static final String API_USER_FLOCASH_SANDBOX = "flotravel";
    public static final String API_PASSWORD_FLOCASH_SANDBOX = "Flo@1234travel";
    // live env
    public static final String MERCHANT_FLOTRAVEL_LIVE = "flotravel@mobirr.com";
    public static final String API_USER_FLOCASH_LIVE = "flotravel";
    public static final String API_PASS_FLOCASH_LIVE = "Flo@1234travel";


    public static final String CURRENCY_DEFAULT = "USD";
    public static final String FLOCASH_OPTN = "123";
    public static final String MERCHANT_FLOTRAVEL_SANDBOX = "flotravel@mobirr.com";
}
