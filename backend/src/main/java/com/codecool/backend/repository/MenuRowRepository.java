package com.codecool.backend.repository;

import com.codecool.backend.modell.menu.MenuRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRowRepository extends JpaRepository<MenuRow, Long> {
}
