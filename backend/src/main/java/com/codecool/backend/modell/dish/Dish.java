package com.codecool.backend.modell.dish;

import java.util.List;

public class Dish {
    private int id;
    private String name;
    private String description;
    private String imageURL;
    private double price;
    private Course course;
    private double averageRating;
    private double weight;
    private int stock;
    private List<Allergen> allergens;

    public Dish(int id, String name, String description, String imageURL, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
    }

    public int getId() {
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
