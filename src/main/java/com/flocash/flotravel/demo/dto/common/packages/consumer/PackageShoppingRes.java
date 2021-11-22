package com.flocash.flotravel.demo.dto.common.packages.consumer;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageShoppingRes extends BaseResponse {
    List<PackageShoppingItem> result;
}
