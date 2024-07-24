package com.codecool.backend.modell.dish;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Dish {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;
    private String imageURL;
    private double price;
    private double averageRating;
    @ManyToMany
    private Set<Allergen> allergens;

    public Dish() {
    }

    public Dish(String name, String description, String imageURL, double price) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
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

    public String getImageURL() {
        return imageURL;
    }

    public double getPrice() {
        return price;
    }
}
