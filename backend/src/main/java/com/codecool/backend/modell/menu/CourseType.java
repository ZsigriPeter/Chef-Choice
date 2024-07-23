package com.codecool.backend.modell.menu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CourseType {
    @Id
    @GeneratedValue
    private long id;
    private String name;
}
