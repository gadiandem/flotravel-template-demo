package com.flocash.flotravel.demo.dto.flocash.exchange;

import lombok.Data;

@Data
public class ExchangeError {
    private String errorId;
    private String errorMsg;
    private String errorCode;
}
