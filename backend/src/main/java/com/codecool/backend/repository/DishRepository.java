package com.codecool.backend.repository;

import com.codecool.backend.modell.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {

}
