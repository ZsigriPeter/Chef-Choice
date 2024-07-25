package com.codecool.backend.controller.dto;

import com.codecool.backend.modell.dish.Dish;
import com.codecool.backend.modell.menu.CourseType;
import com.codecool.backend.modell.menu.WeeklyMenu;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record MenuItemDTO(
        Long id,
        CourseTypeDTO course,
        String code,
        DishDTO dish,
        int dayIndex) {
}
