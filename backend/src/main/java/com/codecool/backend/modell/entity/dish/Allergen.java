package com.codecool.backend.modell.entity.dish;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class Allergen {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int number;


    public Allergen(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Allergen() {
    }
}
