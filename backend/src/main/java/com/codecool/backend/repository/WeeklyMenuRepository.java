package com.codecool.backend.repository;

import com.codecool.backend.modell.menu.WeeklyMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyMenuRepository extends JpaRepository<WeeklyMenu, Long> {
}
