package com.codecool.backend.modell.menu;

import com.codecool.backend.modell.dish.Course;
import com.codecool.backend.modell.dish.Dish;

import java.util.ArrayList;
import java.util.List;

public class MenuRow {
    private Course course;
    private String code;
    private List<Dish> dishes;

    public MenuRow(Course course, String code) {
        this.course = course;
        this.code = code;
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public Course getCourse() {
        return course;
    }

    public String getCode() {
        return code;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
