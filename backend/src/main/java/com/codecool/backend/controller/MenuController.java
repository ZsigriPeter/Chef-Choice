package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.MainPageDTO;
import com.codecool.backend.modell.menu.WeeklyMenu;
import com.codecool.backend.service.DishService;
import com.codecool.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private DishService dishService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/weekly-menu")
    public WeeklyMenu getMenu() {
        return menuService.getMenu();
    }

    @GetMapping("/main-page")
    public MainPageDTO getMainPageContent() {
        return new MainPageDTO("Welcome to Chef Choice", "picture URL");
    }
}