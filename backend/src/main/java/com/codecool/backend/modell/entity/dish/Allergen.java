package com.codecool.backend.modell.entity.dish;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Allergen {
    @Id
    @GeneratedValue
    private Long id;
    private String name;


    public Allergen(String name) {
        this.name = name;
    }

    public Allergen() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
