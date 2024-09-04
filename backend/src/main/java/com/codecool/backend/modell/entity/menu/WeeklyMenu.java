package com.codecool.backend.modell.entity.menu;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
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

}
