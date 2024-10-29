package com.codecool.backend.service;

import com.codecool.backend.controller.dish.DishAlreadyInDbException;
import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.food.DishDTO;
import com.codecool.backend.modell.entity.dish.Allergen;
import com.codecool.backend.modell.entity.dish.Dish;
import com.codecool.backend.modell.payload.NewDishRequest;
import com.codecool.backend.repository.AllergenRepository;
import com.codecool.backend.repository.DishRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DishServiceTest {

    @Mock
    private DishRepository dishRepository;

    @Mock
    private AllergenRepository allergenRepository;

    @InjectMocks
    private DishService dishService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllDishes_ShouldReturnDishDTOList() {
        // Arrange
        Dish dish1 = new Dish("Pizza", "Cheese and tomato", 12.99, Set.of());
        Dish dish2 = new Dish("Pasta", "Tomato and basil", 9.99, Set.of());
        when(dishRepository.findAll()).thenReturn(List.of(dish1, dish2));

        // Act
        List<DishDTO> result = dishService.getAllDishes();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Pizza", result.get(0).name());
        assertEquals("Pasta", result.get(1).name());
        verify(dishRepository, times(1)).findAll();
    }

    @Test
    void getDishById_ShouldReturnDishDTO_WhenDishExists() {
        // Arrange
        Dish dish = new Dish("Pizza", "Cheese and tomato", 12.99, Set.of());
        when(dishRepository.findById(1L)).thenReturn(Optional.of(dish));

        // Act
        DishDTO result = dishService.getDishById(1L);

        // Assert
        assertEquals("Pizza", result.name());
        verify(dishRepository, times(1)).findById(1L);
    }

    @Test
    void getDishById_ShouldThrowException_WhenDishNotFound() {
        // Arrange
        when(dishRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> dishService.getDishById(1L));
    }

    @Test
    void addNewDish_ShouldThrowException_WhenDishAlreadyExists() {
        // Arrange
        NewDishRequest newDishRequest = new NewDishRequest("Pizza", "Cheese and tomato", "12.99", new String[]{"Gluten"});
        Dish existingDish = new Dish("Pizza", "Cheese and tomato", 12.99, Set.of());

        when(dishRepository.findByName("Pizza")).thenReturn(Optional.of(existingDish));

        // Act & Assert
        assertThrows(NullPointerException.class, () -> dishService.addNewDish(newDishRequest));
        verify(dishRepository, never()).save(any(Dish.class));
    }
}
