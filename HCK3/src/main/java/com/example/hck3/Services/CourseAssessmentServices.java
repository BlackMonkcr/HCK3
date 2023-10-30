package com.example.hck3.Services;

import com.example.hck3.Domain.*;
import com.example.hck3.Infrastructure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAssessmentServices {
    private final CourseAssessmentRepository courseAssessmentRepository;
    private final CourseRepository courseRepository;
    private final PeriodoRepository periodoRepository;

    @Autowired
    public CourseAssessmentServices(CourseAssessmentRepository courseAssessmentRepository,
                                    CourseRepository courseRepository,
                                    PeriodoRepository periodoRepository) {
        this.courseAssessmentRepository = courseAssessmentRepository;
        this.courseRepository = courseRepository;
        this.periodoRepository = periodoRepository;
    }

    public CourseAssessment createCourseAssessment(CourseAssessment courseAssessment) {
        return courseAssessmentRepository.save(courseAssessment);
    }

    public List<CourseAssessment> getCourseAssessmentAll() {
        return courseAssessmentRepository.findAll();
    }

    public CourseAssessment getCourseAssessment(Long id) {
        return courseAssessmentRepository.findById(id).orElse(null);
    }

    public CourseAssessment assignCourse(Long id, Long courseId) {
        CourseAssessment courseAssessment = courseAssessmentRepository.findById(id).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        courseAssessment.setCourse(course);
        return courseAssessmentRepository.save(courseAssessment);
    }

    public CourseAssessment assignPeriodo(Long id, Long periodoId) {
        CourseAssessment courseAssessment = courseAssessmentRepository.findById(id).orElseThrow();
        Periodo periodo = periodoRepository.findById(periodoId).orElseThrow();
        courseAssessment.setPeriodo(periodo);
        return courseAssessmentRepository.save(courseAssessment);
    }
}