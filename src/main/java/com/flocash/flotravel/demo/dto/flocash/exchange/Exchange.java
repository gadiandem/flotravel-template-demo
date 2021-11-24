package com.flocash.flotravel.demo.dto.flocash.exchange;

import lombok.Data;

@Data
public class Exchange {
    private ExchangeSource source;
    private ExchangeDest dest;
    private double rate;
}
