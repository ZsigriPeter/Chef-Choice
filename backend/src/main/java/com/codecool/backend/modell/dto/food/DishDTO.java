package com.codecool.backend.modell.dto.food;

import java.util.Set;

public record DishDTO(Long id, String name,
                      String description,
                      double price,
                      Set<AllergenDTO> allergens) {
}
