package com.codecool.backend.controller;

import com.codecool.backend.modell.dto.food.AllergenDTO;
import com.codecool.backend.service.AllergenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RequestMapping("/api")
@RestController
public class AllergenController {

    private final AllergenService allergenService;

    public AllergenController(AllergenService allergenService) {
        this.allergenService = allergenService;
    }

    @GetMapping("/allergen/all")
    public Set<AllergenDTO> getAllAllergens() {
        return allergenService.getAllAllergen();
    }

}
