package com.codecool.backend.repository;

import com.codecool.backend.modell.menu.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTypeRepository extends JpaRepository<CourseType, Long> {
}
