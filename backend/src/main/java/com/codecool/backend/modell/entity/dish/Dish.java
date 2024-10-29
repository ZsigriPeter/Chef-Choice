package com.codecool.backend.modell.entity.dish;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Entity
@Setter
public class Dish {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    private double price;

    @ManyToMany
    private Set<Allergen> allergens;

    public Dish() {
    }

    public Dish(String name, String description, double price, Set<Allergen> allergens) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.allergens = new HashSet<>(allergens);
    }

    public Dish(String name) {
    }
}
