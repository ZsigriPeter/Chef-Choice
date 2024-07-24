package com.codecool.backend.modell.dish;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;
import java.util.Set;

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
