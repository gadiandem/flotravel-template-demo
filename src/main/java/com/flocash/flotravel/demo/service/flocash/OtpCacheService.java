package com.flocash.flotravel.demo.service.flocash;

import com.flocash.flotravel.demo.dto.flocash.OtpCache;

public interface OtpCacheService {
    OtpCache saveOtpCard(OtpCache card);
    OtpCache getOtpCard(String traceNumber);
}
