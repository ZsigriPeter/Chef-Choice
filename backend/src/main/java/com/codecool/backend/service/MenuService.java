package com.codecool.backend.service;

import com.codecool.backend.controller.NoMenuForDateException;
import com.codecool.backend.controller.dto.DTOMapper;
import com.codecool.backend.controller.dto.WeeklyMenuDTO;
import com.codecool.backend.modell.menu.WeeklyMenu;
import com.codecool.backend.repository.WeeklyMenuRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MenuService {

    private WeeklyMenuRepository weeklyMenuRepository;

    public MenuService(WeeklyMenuRepository weeklyMenuRepository) {
        this.weeklyMenuRepository = weeklyMenuRepository;
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
}
