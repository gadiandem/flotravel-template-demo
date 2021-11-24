package com.flocash.flotravel.demo.dto.search.destination;

import com.flocash.flotravel.demo.dto.common.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationRes extends BaseResponse {
    private List<DestinationItem> result;
}
