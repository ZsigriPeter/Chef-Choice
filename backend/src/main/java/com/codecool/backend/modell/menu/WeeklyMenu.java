package com.codecool.backend.modell.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeeklyMenu {

    @Id
    @GeneratedValue
    private Long id;
    private int year;
    private int weekNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany(mappedBy = "weeklyMenu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MenuItem> menuItems;

    public WeeklyMenu(int year, int weekNumber, LocalDate startDate, LocalDate endDate) {
        this.year = year;
        this.weekNumber = weekNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.menuItems = new ArrayList<>();
    }

    public WeeklyMenu() {
    }

    public int getYear() {
        return year;
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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Long getId() {
        return id;
    }
}
