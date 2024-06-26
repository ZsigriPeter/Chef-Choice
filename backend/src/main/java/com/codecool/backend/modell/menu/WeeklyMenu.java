package com.codecool.backend.modell.menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeeklyMenu {
    private int week;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<MenuRow> menuRows;

    public WeeklyMenu(int week, LocalDate startDate, LocalDate endDate) {
        this.week = week;
        this.startDate = startDate;
        this.endDate = endDate;
        this.menuRows = new ArrayList<>();
    }

    public void addMenuRow(MenuRow menuRow) {
        menuRows.add(menuRow);
    }

    public int getWeek() {
        return week;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<MenuRow> getMenuRows() {
        return menuRows;
    }
}
