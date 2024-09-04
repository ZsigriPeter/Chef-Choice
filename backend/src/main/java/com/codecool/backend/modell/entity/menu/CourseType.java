package com.codecool.backend.modell.entity.menu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class CourseType {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    public CourseType() {
    }

    public CourseType(String name) {
        this.name = name;
    }
}
