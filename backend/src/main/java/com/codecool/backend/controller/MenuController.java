package com.codecool.backend.controller;

import com.codecool.backend.modell.dto.MainPageDTO;
import com.codecool.backend.modell.dto.food.MenuItemDTO;
import com.codecool.backend.modell.dto.food.WeeklyMenuDTO;
import com.codecool.backend.service.DishService;
import com.codecool.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MenuController {

    private DishService dishService;
    private MenuService menuService;

    @Autowired
    public MenuController(DishService dishService, MenuService menuService) {
        this.dishService = dishService;
        this.menuService = menuService;
    }

    @GetMapping("/api/public/menu-item")
    public MenuItemDTO getMenuItemById(@RequestParam long id) {
        return menuService.getMenuItemById(id);
    }

    @GetMapping("/api/public/weekly-menu")
    public WeeklyMenuDTO getMenu(@RequestParam LocalDate date) {
        return menuService.getMenu(date);
    }

    @GetMapping("/api/public/main-page")
    public MainPageDTO getMainPageContent() {
        return new MainPageDTO("Welcome to Chef Choice", "picture URL");
    }
}
