package com.codecool.backend.dao;

import com.codecool.backend.modell.menu.WeeklyMenu;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class MemoryMenuDAO implements MenuDAO {

    @Override
    public WeeklyMenu getMenu() {
        return new WeeklyMenu(26, LocalDate.of(2024, 6, 24)
                , LocalDate.of(2024, 6, 28));

    }
}
