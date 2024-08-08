package com.codecool.backend.repository;

import com.codecool.backend.modell.entity.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAll();
    Optional<Dish> findById(Long id);
}
