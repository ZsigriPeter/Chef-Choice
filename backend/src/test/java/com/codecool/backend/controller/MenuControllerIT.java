package com.codecool.backend.controller;

import com.codecool.backend.BackendApplication;
import com.codecool.backend.modell.dto.food.AllergenDTO;
import com.codecool.backend.modell.dto.food.CourseTypeDTO;
import com.codecool.backend.modell.dto.food.DishDTO;
import com.codecool.backend.modell.dto.food.MenuItemDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BackendApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integration-test.properties")
public class MenuControllerIT {

    @Autowired
    private MockMvc mockMvc;
    private MenuItemDTO menuItemDTO;
    private LocalDate testDate;

    @BeforeEach
    void setup() {
        testDate = LocalDate.of(2022, 2, 2);
        menuItemDTO = new MenuItemDTO(0L, new CourseTypeDTO(0L, "")
                , "", new DishDTO(0L, "", "", 2
                , Set.of(new AllergenDTO("", 1))), 1, testDate);
    }

    @Test
    void getMenuItemByIdTestGivenValidIdReturnsMenuItemDTO() throws Exception {
        this.mockMvc.perform(get("/api/menu-item/100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.code").value("S1"));
    }
}
