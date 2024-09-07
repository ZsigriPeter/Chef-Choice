package com.codecool.backend.service;

import com.codecool.backend.controller.dish.DishAlreadyInDbException;
import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.food.AllergenDTO;
import com.codecool.backend.modell.dto.food.DishDTO;
import com.codecool.backend.modell.entity.dish.Allergen;
import com.codecool.backend.modell.entity.dish.Dish;
import com.codecool.backend.modell.payload.NewDishRequest;
import com.codecool.backend.repository.AllergenRepository;
import com.codecool.backend.repository.DishRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

@Service
public class DishService {
    private final DishRepository dishRepository;
    private final AllergenRepository allergenRepository;

    @Autowired
    public DishService(DishRepository dishRepository, AllergenRepository allergenRepository) {
        this.dishRepository = dishRepository;
        this.allergenRepository = allergenRepository;
    }

    public List<DishDTO> getAllDishes() {
        return dishRepository.findAll().stream().map(DTOMapper::toDishDTO).toList();
    }

    public DishDTO getDishById(long id) {
        return DTOMapper.toDishDTO(dishRepository.findById(id).orElseThrow());
    }

    public void addNewDish(NewDishRequest dish) {
        ObjectMapper mapper = new ObjectMapper();
        if (dishRepository.findByName(dish.getName()).isEmpty()) {
            Set<Allergen> allergens = Arrays.stream(dish.getAllergens())
                    .map(object-> {
                        System.out.println(object);
                        return mapper.convertValue(object, AllergenDTO.class);
                    })
                    .map((allergen) -> allergenRepository.findByName(allergen.name()).orElseThrow())
                    .collect(Collectors.toSet());
            Dish newDish = new Dish(dish.getName(), dish.getDescription(), parseDouble(dish.getPrice()), allergens);
            dishRepository.save(newDish);
        } else throw new DishAlreadyInDbException();
    }
}
