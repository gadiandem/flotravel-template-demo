package com.flocash.flotravel.demo.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthBasic {
    private String userName;
    private String password;
}
