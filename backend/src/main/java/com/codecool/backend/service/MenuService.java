package com.codecool.backend.service;

import com.codecool.backend.dao.DishDAO;
import com.codecool.backend.dao.MenuDAO;
import com.codecool.backend.dao.MenuRowDAO;
import com.codecool.backend.modell.dish.Dish;
import com.codecool.backend.modell.menu.MenuRow;
import com.codecool.backend.modell.menu.WeeklyMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    private MenuDAO menuDAO;
    private MenuRowDAO menuRowDAO;
    private DishDAO dishDAO;

    @Autowired
    public MenuService(MenuDAO menuDAO, MenuRowDAO menuRowDAO, DishDAO dishDAO) {
        this.menuDAO = menuDAO;
        this.menuRowDAO = menuRowDAO;
        this.dishDAO = dishDAO;
    }

    public WeeklyMenu getMenu() {
        WeeklyMenu menu = menuDAO.getMenu();

        MenuRow menuRow1 = menuRowDAO.getMenuRowByCode("S1");
        MenuRow menuRow2 = menuRowDAO.getMenuRowByCode("M1");
        MenuRow menuRow3 = menuRowDAO.getMenuRowByCode("D1");

        Dish gulash = dishDAO.getDishById(1);
        Dish wiener = dishDAO.getDishById(2);
        Dish crepes = dishDAO.getDishById(3);

        for (int i = 0; i < 5; i++) {
            menuRow1.addDish(gulash);
            menuRow2.addDish(wiener);
            menuRow3.addDish(crepes);
        }

        menu.addMenuRow(menuRow1);
        menu.addMenuRow(menuRow2);
        menu.addMenuRow(menuRow3);

        return menu;
    }
}
