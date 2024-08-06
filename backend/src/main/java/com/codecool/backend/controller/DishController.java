package com.codecool.backend.controller;

import com.codecool.backend.modell.dto.food.DishDTO;
import com.codecool.backend.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {
    private DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/api/public/food-list")
    public List<DishDTO> getAllDishes() {
        return dishService.getAllDishes();
    }
}



