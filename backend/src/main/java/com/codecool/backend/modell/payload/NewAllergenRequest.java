package com.codecool.backend.modell.payload;

import lombok.Data;

@Data
public class NewAllergenRequest {
    private String name;
    private int number;
}
