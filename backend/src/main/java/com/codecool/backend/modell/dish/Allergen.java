package com.codecool.backend.modell.dish;

public enum Allergen {
    A1(1, "Gluten"),
    A2(2, "Crustaceans"),
    A3(3, "Eggs"),
    A4(4, "Fish");

    public int id;
    public String name;

    Allergen(int id, String name) {
        this.id = id;
        this.name = name;
    }

/*    Gluten
            Crustaceans
    Eggs
            Fish
    Peanuts
            Soybeans
    Milk
    Tree nuts
    Celery
            Mustard
    Sesame seeds
    Sulphur dioxide and sulphites
    Lupin
            Molluscs*/
}
