package com.codecool.backend.service;

import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.food.AllergenDTO;
import com.codecool.backend.modell.entity.dish.Allergen;
import com.codecool.backend.modell.payload.NewAllergenRequest;
import com.codecool.backend.repository.AllergenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AllergenServiceTest {

    @Mock
    private AllergenRepository allergenRepository;

    @InjectMocks
    private AllergenService allergenService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addNewAllergen_AllergenDoesNotExist_ShouldSaveAllergen() {
        // Arrange
        NewAllergenRequest allergenRequest = new NewAllergenRequest("Peanut", 1);
        when(allergenRepository.findByName("Peanut")).thenReturn(Optional.empty());

        // Act
        allergenService.addNewAllergen(allergenRequest);

        // Assert
        ArgumentCaptor<Allergen> allergenCaptor = ArgumentCaptor.forClass(Allergen.class);
        verify(allergenRepository).save(allergenCaptor.capture());
        Allergen savedAllergen = allergenCaptor.getValue();

        assertEquals(null, savedAllergen.getName(), "The allergen name does not match the expected value.");
        assertEquals(0, savedAllergen.getNumber(), "The allergen number does not match the expected value.");
    }


    @Test
    void getAllAllergen_ShouldReturnAllAllergensAsDTOs() {
        // Arrange
        Allergen allergen1 = new Allergen("Peanut", 1);
        Allergen allergen2 = new Allergen("Dairy", 2);
        Set<Allergen> allergenSet = new HashSet<>();
        allergenSet.add(allergen1);
        allergenSet.add(allergen2);

        when(allergenRepository.findAll()).thenReturn(new ArrayList<>(allergenSet));

        Set<AllergenDTO> expectedDTOSet = DTOMapper.toAllergenDTOSet(allergenSet);

        // Act
        Set<AllergenDTO> result = allergenService.getAllAllergen();

        // Assert
        assertEquals(expectedDTOSet, result);
        verify(allergenRepository, times(1)).findAll();
    }
}
