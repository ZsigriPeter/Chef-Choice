package com.codecool.backend.modell.dto.food;

import java.time.LocalDate;

public record CartItemDTO(
        Long id,
        CourseTypeDTO course,
        String code,
        DishDTO dish,
        LocalDate dateOfDelivery) {
}
