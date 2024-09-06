package com.codecool.backend.controller.dish;

import com.codecool.backend.modell.dto.food.DishDTO;
import com.codecool.backend.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class DishController {
    private DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/food-list")
    public List<DishDTO> getAllDishes() {
        return dishService.getAllDishes();
    }

    @GetMapping("/food")
    public DishDTO getDishById(@RequestParam long id) {
        return dishService.getDishById(id);
    }


}



