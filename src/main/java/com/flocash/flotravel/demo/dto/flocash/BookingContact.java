package com.flocash.flotravel.demo.dto.flocash;

import lombok.Data;

@Data
public class BookingContact {
    private String email;
    private String password;
    private boolean createAccount = false;
}
