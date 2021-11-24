package com.flocash.flotravel.demo.dto.flocash.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payer  {
    private String country;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
}