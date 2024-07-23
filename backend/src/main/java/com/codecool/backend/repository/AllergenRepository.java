package com.codecool.backend.repository;

import com.codecool.backend.modell.dish.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergenRepository extends JpaRepository<Allergen, Long> {
}
