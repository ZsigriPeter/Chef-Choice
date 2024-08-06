package com.codecool.backend.service;

import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.DishDTO;
import com.codecool.backend.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<DishDTO> getAllDishes() {
        return dishRepository.findAll().stream().map(DTOMapper::toDishDTO).toList();
    }
}
