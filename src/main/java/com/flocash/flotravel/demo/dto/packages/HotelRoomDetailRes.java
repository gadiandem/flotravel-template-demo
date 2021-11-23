package com.flocash.flotravel.demo.dto.packages;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRoomDetailRes extends BaseResponse {
    List<HotelRoomDetailItem> result;
}
