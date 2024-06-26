package com.codecool.backend.dao;

import com.codecool.backend.modell.dish.Dish;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryDishDAO implements DishDAO{

    @Override
    public Dish getDishById() {
        return null;
    }




    private static void createInstances() {

    }
}
