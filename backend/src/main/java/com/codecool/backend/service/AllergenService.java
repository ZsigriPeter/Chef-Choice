package com.codecool.backend.service;

import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.food.AllergenDTO;
import com.codecool.backend.modell.entity.dish.Allergen;
import com.codecool.backend.modell.payload.NewAllergenRequest;
import com.codecool.backend.repository.AllergenRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AllergenService {

    private final AllergenRepository allergenRepository;

    public AllergenService(AllergenRepository allergenRepository) {
        this.allergenRepository = allergenRepository;
    }

    public void addNewAllergen(NewAllergenRequest allergen) {
        Allergen newAllergen = new Allergen(allergen.getName(), allergen.getNumber());
        if (allergenRepository.findByName(allergen.getName()).isEmpty()) {
            allergenRepository.save(newAllergen);
        }
    }

    public Set<AllergenDTO> getAllAllergen() {
        Set<Allergen> allergens = new HashSet<>(allergenRepository.findAll());
        return DTOMapper.toAllergenDTOSet(allergens);
    }
}
