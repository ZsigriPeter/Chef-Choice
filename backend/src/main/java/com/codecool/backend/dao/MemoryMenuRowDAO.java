package com.codecool.backend.dao;

import com.codecool.backend.modell.dish.Course;
import com.codecool.backend.modell.menu.MenuRow;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryMenuRowDAO implements MenuRowDAO{

    @Override
    public MenuRow getMenuRowByCode(String code) {
        if (code.equals("S1")) return new MenuRow(Course.SOUP, "S1");
        if (code.equals("M1")) return new MenuRow(Course.MAIN, "M1");
        if (code.equals("D1")) return new MenuRow(Course.DESSERT, "D1");
        return null;
    }
}
