package com.codecool.backend.modell.dto;

public record MenuItemDTO(
        Long id,
        CourseTypeDTO course,
        String code,
        DishDTO dish,
        int dayIndex) {
}
