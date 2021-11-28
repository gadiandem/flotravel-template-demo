package com.flocash.flotravel.demo.util;

import java.util.Map;

import static com.flocash.flotravel.demo.constant.Constant.SANDBOX_ENV;

public class RequestHeaderUtil {
    public static String getEnvironmentHeader(Map<String, String> headers) {
        String environment = headers.get("environment");
        if (environment == null || environment.isEmpty()) {
            environment = SANDBOX_ENV;
        }
        return environment;
    }

    public static String getUserIdHeader(Map<String, String> headers) {
        String userId = headers.get("user-id");
        return userId;
    }

    public static String getWalletVCNTokenHeader(Map<String, String> headers) {
        String userId = headers.get("user-id");
        return userId;
    }

}

