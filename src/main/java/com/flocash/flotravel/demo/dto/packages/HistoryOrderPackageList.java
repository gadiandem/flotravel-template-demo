package com.flocash.flotravel.demo.dto.packages;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class HistoryOrderPackageList {
    private List<HistoryOrderPackageListItem> bookingList;
    private List<HistoryOrderPackageListItem> agentBookingList;
}
