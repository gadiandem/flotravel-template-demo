package com.flocash.flotravel.demo.dto.flocash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundParameter {

    private String statement;
    private String id;
}
