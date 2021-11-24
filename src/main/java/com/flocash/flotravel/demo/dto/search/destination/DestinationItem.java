package com.flocash.flotravel.demo.dto.search.destination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationItem {
    private String id;
    private Destination.Type type;
    private String displayName;
}
