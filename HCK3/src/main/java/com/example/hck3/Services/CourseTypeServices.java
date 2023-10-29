package com.example.hck3.Services;

import com.example.hck3.Domain.*;
import com.example.hck3.Infrastructure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeServices {
    private final CourseTypeRepository courseTypeRepository;

    @Autowired
    public CourseTypeServices(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }

    public CourseType createCourseType(CourseType courseType) {
        return courseTypeRepository.save(courseType);
    }

    public List<CourseType> getCourseTypeAll() {
        return courseTypeRepository.findAll();
    }

    public CourseType getCourseType(Long id) {
        return courseTypeRepository.findById(id).orElse(null);
    }
}
