package com.flocash.flotravel.demo.dto.packages.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferInPackage {
    private String id;
//    private String transferId;
    private String transferType;
    private boolean arrival;
    private boolean departure;
    private String currency;
    private BigDecimal amount;
    private String note;

}
