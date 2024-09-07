package com.codecool.backend.modell.payload;

import lombok.Data;

@Data
public class NewMenuItemRequest {
    private String dishName;
    private String dishType;
    private String dishCode;
    private int dayNumber;
    private String startDate;
}
