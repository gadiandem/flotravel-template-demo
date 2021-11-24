package com.flocash.flotravel.demo.dto.common;

import lombok.Data;

@Data
public class CustomerBookingInfo {
    private Gender gender;
    private String firstName;
    private String middleName;
    private String lastName;
    private String country;
    private String mobile;
    private boolean isNotify;
    private String passport;
    private String customerComment;
    private Titulation titulation;
}
