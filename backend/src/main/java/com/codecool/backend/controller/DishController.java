package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.MainPageDTO;
import com.codecool.backend.modell.Dish;
import com.codecool.backend.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    private DishService dishService;

//    @GetMapping("/weekly-menu")
//    public List<Dish> getDishes() {
//        return dishService.getAllDishes();
//    }

    @GetMapping("/main-page")
    public MainPageDTO getMainPageContent() {
        return new MainPageDTO("Daily message","picture URL");
    }
}
