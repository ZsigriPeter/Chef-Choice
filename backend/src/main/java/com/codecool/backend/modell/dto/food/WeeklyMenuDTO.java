package com.codecool.backend.modell.dto.food;

import java.time.LocalDate;
import java.util.List;

public record WeeklyMenuDTO(Long id, int week, LocalDate startDate, LocalDate endDate, List<MenuItemDTO> menuItems) {
}
