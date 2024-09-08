package com.codecool.backend.service;

//import com.codecool.backend.controller.NoMenuForDateException;
import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.food.*;
import com.codecool.backend.modell.entity.menu.MenuItem;
import com.codecool.backend.modell.entity.menu.WeeklyMenu;
import com.codecool.backend.repository.CourseTypeRepository;
import com.codecool.backend.repository.DishRepository;
import com.codecool.backend.repository.MenuItemRepository;
import com.codecool.backend.repository.WeeklyMenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static com.codecool.backend.modell.dto.DTOMapper.toMenuItemDTO;
import static com.codecool.backend.modell.dto.DTOMapper.toWeeklyMenuDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MenuServiceTest {

    private MenuService underTest;
    private WeeklyMenuRepository weeklyMenuRepositoryMock;
    private MenuItemRepository menuItemRepositoryMock;
    private CourseTypeRepository courseTypeRepositoryMock;
    private DishRepository dishRepositoryMock;
    private LocalDate menuStartDate;
    private MenuItem menuItem;
    private MenuItemDTO menuItemDTO0;
    private MenuItemDTO menuItemDTO1;
    private WeeklyMenu weeklyMenu;
    private WeeklyMenuDTO weeklyMenuDTO;


    @BeforeEach
    void setUp() {
        weeklyMenuRepositoryMock = Mockito.mock(WeeklyMenuRepository.class);
        menuItemRepositoryMock = Mockito.mock(MenuItemRepository.class);
        courseTypeRepositoryMock = Mockito.mock(CourseTypeRepository.class);
        dishRepositoryMock = Mockito.mock(DishRepository.class);
        underTest = new MenuService(weeklyMenuRepositoryMock, menuItemRepositoryMock, courseTypeRepositoryMock, dishRepositoryMock);
        LocalDate menuStartDate = LocalDate.of(2022, 2, 2);
        menuItem = new MenuItem();
        menuItemDTO0 = new MenuItemDTO(0L, new CourseTypeDTO(0L, ""), "A1"
                , new DishDTO(0L, "", "", 19.0
                , Set.of(new AllergenDTO("",0))), 1, menuStartDate);
        menuItemDTO1 = new MenuItemDTO(1L, new CourseTypeDTO(0L, ""), "A1"
                , new DishDTO(0L, "", "", 19.0
                , Set.of(new AllergenDTO("", 1))), 1, menuStartDate);
        weeklyMenu = new WeeklyMenu();
        weeklyMenuDTO = new WeeklyMenuDTO(0L, 33, menuStartDate, menuStartDate, List.of(menuItemDTO0, menuItemDTO1));
    }

    @Test
    void getMenuTestGivenValidDateThenReturnsWeeklyMenu() {
        //arrange
        Mockito.when(weeklyMenuRepositoryMock
                        .findByStartDate(menuStartDate))
                .thenReturn(Optional.of(weeklyMenu));
        try (MockedStatic<DTOMapper> dtoMapperMockedStatic = Mockito.mockStatic(DTOMapper.class)) {
            dtoMapperMockedStatic.when(() -> toWeeklyMenuDTO(weeklyMenu))
                    .thenReturn(weeklyMenuDTO);
            //act
            WeeklyMenuDTO actual = underTest.getMenu(menuStartDate);
            //assert
            WeeklyMenuDTO expected = weeklyMenuDTO;
            assertEquals(expected, actual);
        }
    }

//    @Test
//    void getMenuTestGivenEmptyOptionalThenThrowsError() {
//        //arrange
//        Mockito.when(weeklyMenuRepositoryMock
//                        .findByStartDate(menuStartDate))
//                .thenReturn(Optional.empty());
//        //act & assert
//        assertThrows(NoMenuForDateException.class, () -> underTest.getMenu(menuStartDate));
//    }

    @Test
    void getMenuItemByIdGivenValidIdThenReturnsMenuItemDTO() {
        //arrange
        Mockito.when(menuItemRepositoryMock.findById(0L)).thenReturn(Optional.of(menuItem));
        try (MockedStatic<DTOMapper> dtoMapperMockedStatic = Mockito.mockStatic(DTOMapper.class)) {
            dtoMapperMockedStatic.when(() -> toMenuItemDTO(menuItem)).thenReturn(menuItemDTO0);
        //act
        MenuItemDTO actual = underTest.getMenuItemById(0L);
        //assert
        MenuItemDTO expected = menuItemDTO0;
        assertEquals(expected, actual);
        }
    }

    @Test
    void getMenuItemByIdGivenEmptyOptionalThenThrowsError() {
        //arrange
        Mockito.when(menuItemRepositoryMock.findById(2L)).thenReturn(Optional.empty());
        //act & arrange
        assertThrows(NoSuchElementException.class, () -> underTest.getMenuItemById(2L));
    }
}