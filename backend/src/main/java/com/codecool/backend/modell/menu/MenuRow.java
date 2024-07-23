package com.codecool.backend.modell.menu;

import com.codecool.backend.modell.dish.Dish;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MenuRow {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private CourseType course;
    private String code;
    @OneToMany
    private List<MenuItem> dishes;

    public MenuRow(CourseType course, String code) {
        this.course = course;
        this.code = code;
        this.dishes = new ArrayList<>();
    }

    public MenuRow() {
    }


    public CourseType getCourse() {
        return course;
    }

    public String getCode() {
        return code;
    }

    public List<MenuItem> getDishes() {
        return dishes;
    }

    public Long getId() {
        return id;
    }
}
