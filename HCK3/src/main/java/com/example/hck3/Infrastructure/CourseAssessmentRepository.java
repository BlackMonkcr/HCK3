package com.example.hck3.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hck3.Domain.*;

public interface CourseAssessmentRepository extends JpaRepository<CourseAssessment, Long> {}