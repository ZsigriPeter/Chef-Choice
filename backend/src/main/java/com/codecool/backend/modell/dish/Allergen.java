package com.codecool.backend.modell.dish;

public enum Allergen {
    A1(1, "Gluten"),
    A2(2, "Crustaceans"),
    A3(3, "Eggs"),
    A4(4, "Fish"),
    A5(5, "Peanuts"),
    A6(6, "Soybeans"),
    A7(7, "Milk"),
    A8(8, "Tree nuts"),
    A9(9, "Celery"),
    A10(10, "Mustard"),
    A11(11, "Sesame seeds"),
    A12(12, "Sulphur dioxide and sulphites"),
    A13(13, "Lupin"),
    A14(14, "Molluscs")
    ;

    public final int id;
    public final String name;

    Allergen(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
