package com.codecool.backend.repository;

import com.codecool.backend.modell.menu.WeeklyMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface WeeklyMenuRepository extends JpaRepository<WeeklyMenu, Long> {
    Optional<WeeklyMenu> findByStartDate(LocalDate startDate);
}
