package com.example.hck3.Application;

import com.example.hck3.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hck3.Domain.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/courseType")
public class CourseTypeController {
    private final CourseTypeServices courseTypeServices;

    @Autowired
    public CourseTypeController(CourseTypeServices courseTypeServices) {
        this.courseTypeServices = courseTypeServices;
    }

    @PostMapping
    public ResponseEntity<CourseType> createCourseType(@RequestBody CourseType courseType) {
        CourseType newCourseType = courseTypeServices.createCourseType(courseType);
        return new ResponseEntity<>(newCourseType, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseType>> getCourseTypeAll() {
        List<CourseType> courseTypeList = courseTypeServices.getCourseTypeAll();
        return new ResponseEntity<>(courseTypeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseType> getCourseType(@PathVariable("id") Long id) {
        CourseType courseType = courseTypeServices.getCourseType(id);
        if (courseType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseType, HttpStatus.OK);
    }
}
