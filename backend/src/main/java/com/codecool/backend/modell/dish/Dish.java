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

}
