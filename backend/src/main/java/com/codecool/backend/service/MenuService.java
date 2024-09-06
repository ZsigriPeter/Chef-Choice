package com.codecool.backend.service;

import com.codecool.backend.controller.NoMenuForDateException;
import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.food.MenuItemDTO;
import com.codecool.backend.modell.dto.food.WeeklyMenuDTO;
import com.codecool.backend.modell.entity.menu.MenuItem;
import com.codecool.backend.modell.entity.menu.WeeklyMenu;
import com.codecool.backend.repository.MenuItemRepository;
import com.codecool.backend.repository.WeeklyMenuRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MenuService {

    private final WeeklyMenuRepository weeklyMenuRepository;
    private final MenuItemRepository menuItemRepository;

    public MenuService(WeeklyMenuRepository weeklyMenuRepository, MenuItemRepository menuItemRepository) {
        this.weeklyMenuRepository = weeklyMenuRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public WeeklyMenuDTO getMenu(LocalDate startDate) {
        Optional<WeeklyMenu> foundWeeklyMenu = weeklyMenuRepository.findByStartDate(startDate);
        if (foundWeeklyMenu.isPresent()) {
            WeeklyMenu foundMenu = foundWeeklyMenu.get();
            return DTOMapper.toWeeklyMenuDTO(foundMenu);
        } else {
            throw new NoMenuForDateException();
        }
    }

    public MenuItemDTO getMenuItemById(long id) {
        Optional<MenuItem> foundMenuItem = menuItemRepository.findById(id);
        if (foundMenuItem.isPresent()) {
            return DTOMapper.toMenuItemDTO(foundMenuItem.get());
        } else {
            throw new NoSuchElementException();
        }
    }

    public MenuItem getMenuItemByIdMenuItem(long id) {
        Optional<MenuItem> foundMenuItem = menuItemRepository.findById(id);
        if (foundMenuItem.isPresent()) {
            return (foundMenuItem.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}
