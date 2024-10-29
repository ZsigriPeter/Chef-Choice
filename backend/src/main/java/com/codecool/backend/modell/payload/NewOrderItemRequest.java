package com.codecool.backend.modell.payload;

import lombok.Data;

@Data
public class NewOrderItemRequest {
    private long menuItemId;
    private int quantity;

    public NewOrderItemRequest(long menuItemId, int quantity) {
    }
}
