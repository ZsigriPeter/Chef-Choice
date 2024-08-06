package com.codecool.backend.modell.entity.menu;

import com.codecool.backend.modell.entity.dish.Dish;
import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public CourseType getCourse() {
        return course;
    }

    public String getCode() {
        return code;
    }

    public Dish getDish() {
        return dish;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public WeeklyMenu getWeeklyMenu() {
        return weeklyMenu;
    }

}
