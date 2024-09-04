package com.codecool.backend.modell.payload;

import lombok.Data;

@Data
public class NewDishRequest {
    private String name;
    private String description;
    private String price;
    private Object[] allergens = new Object[0];
}
