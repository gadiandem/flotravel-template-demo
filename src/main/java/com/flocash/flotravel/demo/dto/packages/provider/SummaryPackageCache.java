package com.flocash.flotravel.demo.dto.packages.provider;

import com.flocash.flotravel.demo.dto.packages.ItemPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "packages_summary_cache")
public class SummaryPackageCache {
    @Id
    private String id;
    private BigDecimal basePrice;
    private BigDecimal totalPrice;
    private String currency;
    private ItemPrice packageInfo;
    private String hotelId;
    private List<ItemPrice> hotelRooms;
    private List<ItemPrice> supplements;
    private List<ItemPrice> tours;
    private List<ItemPrice> transfers;
    private boolean available;
    private String startDate;
}
