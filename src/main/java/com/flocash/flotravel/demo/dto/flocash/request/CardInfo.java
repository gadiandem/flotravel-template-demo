package com.flocash.flotravel.demo.dto.flocash.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Validated
public class CardInfo implements Serializable {
    @NotBlank(message="CardHotel is required")
    private String cardHolder;
    @NotBlank(message="CardNumber is required")
    private String cardNumber;
    @NotBlank(message="ExpireMonth is required( MM)")
    private String expireMonth;
    @NotBlank(message="ExpireYear is required( YY)")
    private String expireYear;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String cvv;
}
