package com.codecool.backend.modell.entity.menu;

import com.codecool.backend.modell.entity.dish.Dish;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private CourseType course;
    private String code;
    @ManyToOne
    private Dish dish;
    private int dayIndex;
    @ManyToOne
    @JoinColumn(name = "weekly_menu_id")
    private WeeklyMenu weeklyMenu;

    public MenuItem() {
    }

    public MenuItem(CourseType course, String code, Dish dish, int dayIndex, WeeklyMenu weeklyMenu) {
        this.course = course;
        this.code = code;
        this.dish = dish;
        this.dayIndex = dayIndex;
        this.weeklyMenu = weeklyMenu;
    }
}
