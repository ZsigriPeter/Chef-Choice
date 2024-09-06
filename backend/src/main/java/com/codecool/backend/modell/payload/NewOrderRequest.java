package com.codecool.backend.modell.payload;

import lombok.Data;

import java.util.List;

@Data
public class NewOrderRequest {
    private String username;
    private String streetAndHouseNumber;
    private String settlement;
    private String country;
    private int zipCode;
    private List<NewOrderItemRequest> dishList;
}
