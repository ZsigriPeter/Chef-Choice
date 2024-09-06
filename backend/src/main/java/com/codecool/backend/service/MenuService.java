package com.codecool.backend.service;

import com.codecool.backend.controller.menu.NoMenuForDateException;
import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.food.MenuItemDTO;
import com.codecool.backend.modell.dto.food.WeeklyMenuDTO;
import com.codecool.backend.modell.entity.dish.Dish;
import com.codecool.backend.modell.entity.menu.CourseType;
import com.codecool.backend.modell.entity.menu.MenuItem;
import com.codecool.backend.modell.entity.menu.WeeklyMenu;
import com.codecool.backend.modell.payload.NewMenuItemRequest;
import com.codecool.backend.repository.CourseTypeRepository;
import com.codecool.backend.repository.DishRepository;
import com.codecool.backend.repository.MenuItemRepository;
import com.codecool.backend.repository.WeeklyMenuRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MenuService {

    private final WeeklyMenuRepository weeklyMenuRepository;
    private final MenuItemRepository menuItemRepository;
    private final CourseTypeRepository courseTypeRepository;
    private final DishRepository dishRepository;

    public MenuService(WeeklyMenuRepository weeklyMenuRepository, MenuItemRepository menuItemRepository, CourseTypeRepository courseTypeRepository, DishRepository dishRepository) {
        this.weeklyMenuRepository = weeklyMenuRepository;
        this.menuItemRepository = menuItemRepository;
        this.courseTypeRepository = courseTypeRepository;
        this.dishRepository = dishRepository;
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
      
    public void addNewMenuItem(NewMenuItemRequest menuItem) {
        CourseType courseType = courseTypeRepository.findByName(menuItem.getDishType()).orElseThrow();
        Dish dish = dishRepository.findByName(menuItem.getDishName()).orElseThrow();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(menuItem.getStartDate(),dtf);
        WeeklyMenu weeklyMenu = weeklyMenuRepository.findByStartDate(date).orElseThrow();
        int dayIndex = menuItem.getDayNumber() - 1;
        MenuItem newMenuItem = new MenuItem(courseType, menuItem.getDishCode(), dish, dayIndex, weeklyMenu);
        menuItemRepository.save(newMenuItem);
    }
}
