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
@RequestMapping("/course")
public class CourseController {
    private final CourseServices courseServices;

    @Autowired
    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course newCourse = courseServices.createCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourseAll() {
        List<Course> courseList = courseServices.getCourseAll();
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") Long id) {
        Course course = courseServices.getCourse(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PatchMapping("/type")
    public ResponseEntity<Course> assignCourseType(@RequestParam("id") Long id,
                                                   @RequestParam("type_id") Long type_id) {
        courseServices.assignCourseType(id, type_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
