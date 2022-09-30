package com.assess.spring.jpa.repository;

import com.assess.spring.jpa.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Integer> {
}
