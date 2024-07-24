package com.codecool.backend.modell.menu;

import com.codecool.backend.modell.dish.Dish;
import jakarta.persistence.*;

import java.time.LocalDate;

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
    private WeeklyMenu weeklyMenu;

}
