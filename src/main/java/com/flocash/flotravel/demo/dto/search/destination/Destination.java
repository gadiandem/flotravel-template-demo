package com.flocash.flotravel.demo.dto.search.destination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    public enum Type {
        CITY, NEIGHBORHOOD, STATION, HOTEL, AIRPORT
    }

    @Id
    private String id;
    @Field("display_name")
    private String displayName;
    private Coordinate coordinate;
    private ProviderRefer provider;
    private String partner_code;
    private String code;
    private String name;
    private String address;
    private String street;
    private CountryRefer country;
    private CityRefer city;
    private StateRefer state;
    private Type type;
}
