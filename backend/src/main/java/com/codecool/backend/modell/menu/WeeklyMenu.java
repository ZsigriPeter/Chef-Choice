package com.codecool.backend.modell.menu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeeklyMenu {

    @Id
    @GeneratedValue
    private Long id;
    private int weekNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany
    private List<MenuRow> menuRows;

    public WeeklyMenu(int weekNumber, LocalDate startDate, LocalDate endDate) {
        this.weekNumber = weekNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.menuRows = new ArrayList<>();
    }

    public WeeklyMenu() {
    }

    public int getWeekNumber() {
        return weekNumber;
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

    public Long getId() {
        return id;
    }
}
