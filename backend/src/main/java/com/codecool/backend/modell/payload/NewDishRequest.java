package com.codecool.backend.modell.payload;

import lombok.Data;

@Data
public class NewDishRequest {
    private String name;
    private String description;
    private String price;
    private String[] allergens = new String[0];

    public NewDishRequest(String pizza, String cheeseAndTomato, String s, String[] strings) {
    }
}
