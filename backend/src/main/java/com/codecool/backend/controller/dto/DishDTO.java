package com.codecool.backend.controller.dto;

import com.codecool.backend.modell.dish.Allergen;
import jakarta.persistence.ManyToMany;

import java.util.Set;

public record DishDTO(Long id, String name,
                      String description,
                      double price,
                      Set<AllergenDTO> allergens) {
}
