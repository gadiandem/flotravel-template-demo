package com.flocash.flotravel.demo.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationRequest extends BaseResponse {
    private List<Error> errors;
}
