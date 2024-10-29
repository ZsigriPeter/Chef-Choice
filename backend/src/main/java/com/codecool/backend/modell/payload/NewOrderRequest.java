package com.codecool.backend.modell.payload;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewOrderRequest {
    private String username;
    private String streetAndHouseNumber;
    private String settlement;
    private String country;
    private int zipCode;
    private List<NewOrderItemRequest> dishList;

    public NewOrderRequest(String username, String streetAndHouseNumber, String settlement, String country, int zipCode, List<NewOrderItemRequest> dishList) {

    this.username = username;
    this.streetAndHouseNumber = streetAndHouseNumber;
    this.settlement = settlement;
    this.country = country;
    this.zipCode = zipCode;
    this.dishList = new ArrayList<>();
        this.dishList.addAll(dishList);
    }
}
