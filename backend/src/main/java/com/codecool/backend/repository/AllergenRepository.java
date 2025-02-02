package com.codecool.backend.repository;

import com.codecool.backend.modell.entity.dish.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Long> {
    Optional<Allergen> findByName(String allergen);
}
