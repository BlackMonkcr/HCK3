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
@RequestMapping("/courseAssessment")
public class CourseAssessmentController {
    private final CourseAssessmentServices courseAssessmentServices;

    @Autowired
    public CourseAssessmentController(CourseAssessmentServices courseAssessmentServices) {
        this.courseAssessmentServices = courseAssessmentServices;
    }

    @PostMapping
    public ResponseEntity<CourseAssessment> createCourseAssessment(@RequestBody CourseAssessment courseAssessment) {
        CourseAssessment newCourseAssessment = courseAssessmentServices.createCourseAssessment(courseAssessment);
        return new ResponseEntity<>(newCourseAssessment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseAssessment>> getCourseAssessmentAll() {
        List<CourseAssessment> courseAssessmentList = courseAssessmentServices.getCourseAssessmentAll();
        return new ResponseEntity<>(courseAssessmentList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseAssessment> getCourseAssessment(@PathVariable("id") Long id) {
        CourseAssessment courseAssessment = courseAssessmentServices.getCourseAssessment(id);
        if (courseAssessment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseAssessment, HttpStatus.OK);
    }

    @PatchMapping("/Periodo")
    public ResponseEntity<CourseAssessment> updateCourseAssessmentPeriodo(@RequestParam Long id,
                                                                          @RequestParam Long periodo_id) {
        return new ResponseEntity<>(courseAssessmentServices.assignPeriodo(id, periodo_id), HttpStatus.OK);
    }

    @PatchMapping("/Course")
    public ResponseEntity<CourseAssessment> updateCourseAssessmentCourse(@RequestParam Long id,
                                                                         @RequestParam Long course_id) {
        return new ResponseEntity<>(courseAssessmentServices.assignCourse(id, course_id), HttpStatus.OK);
    }
}
