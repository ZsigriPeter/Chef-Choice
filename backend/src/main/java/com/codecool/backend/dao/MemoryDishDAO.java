package com.codecool.backend.dao;

import com.codecool.backend.modell.dish.Dish;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryDishDAO implements DishDAO {

    @Override
    public Dish getDishById(int id) {
        if (id == 1) return new Dish(1, "Goulash", "Beef, potato, carrot, onion", "URL", 990);
        if (id == 2) return new Dish(2, "Wiener schnitzel", "Pork, potato, cucumber", "URL", 1990);
        if (id == 3) return new Dish(3, "Crepes with chocolate", "Flour, milk, egg, cacao", "URL", 1190);
        return null;
    }


}

