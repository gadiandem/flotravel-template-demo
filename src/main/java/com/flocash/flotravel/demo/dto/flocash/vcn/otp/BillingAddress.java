package com.flocash.flotravel.demo.dto.flocash.vcn.otp;

import lombok.Data;

@Data
public class BillingAddress {
    private String fullName;
    private String address1;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phoneNo;
}
