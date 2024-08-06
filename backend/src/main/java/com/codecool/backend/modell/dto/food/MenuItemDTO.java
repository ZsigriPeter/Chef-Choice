package com.codecool.backend.modell.dto.food;

public record MenuItemDTO(
        Long id,
        CourseTypeDTO course,
        String code,
        DishDTO dish,
        int dayIndex) {
}
