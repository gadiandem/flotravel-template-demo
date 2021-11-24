package com.flocash.flotravel.demo.dto.search.destination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country  {
    private String code;
    private String code2;
    private String numCode;
    private String name;
    private String dialCode;
    private String region;
    private String subregion;
    private CountryRefer currency;
}
