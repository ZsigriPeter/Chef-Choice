package com.codecool.backend.modell.payload;

import lombok.Data;

@Data
public class NewDishRequest {
    private String name;
    private String description;
    private double price;
    private String[] allergens = new String[0];
}
