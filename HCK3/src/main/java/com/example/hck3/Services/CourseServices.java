package com.example.hck3.Services;

import com.example.hck3.Domain.*;
import com.example.hck3.Infrastructure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {
    private final CourseRepository courseRepository;
    private final CourseTypeRepository courseTypeRepository;

    @Autowired
    public CourseServices(CourseRepository courseRepository, CourseTypeRepository courseTypeRepository) {
        this.courseRepository = courseRepository;
        this.courseTypeRepository = courseTypeRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getCourseAll() {
        return courseRepository.findAll();
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course assignCourseType(Long courseId, Long courseTypeId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        CourseType courseType = courseTypeRepository.findById(courseTypeId).orElseThrow();
        course.setCourseType(courseType);
        return courseRepository.save(course);
    }
}