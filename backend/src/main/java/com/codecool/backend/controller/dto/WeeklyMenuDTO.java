package com.codecool.backend.controller.dto;

import com.codecool.backend.modell.menu.MenuRow;

import java.time.LocalDate;
import java.util.List;

public record WeeklyMenuDTO(int week, LocalDate startDate, LocalDate endDate, List<MenuRow> menuRows) {
}
