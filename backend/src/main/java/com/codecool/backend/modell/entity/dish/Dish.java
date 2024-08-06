package com.codecool.backend.modell.entity.dish;

import jakarta.persistence.*;

import java.util.Set;

@Entity
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

    public Dish(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public double getPrice() {
        return price;
    }
}
