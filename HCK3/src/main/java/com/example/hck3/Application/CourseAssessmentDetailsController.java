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
@RequestMapping("/course_assessment_details")
public class CourseAssessmentDetailsController {
    private final CourseAssessmentDetailsServices courseAssessmentDetailsService;

    @Autowired
    public CourseAssessmentDetailsController(CourseAssessmentDetailsServices courseAssessmentDetailsService) {
        this.courseAssessmentDetailsService = courseAssessmentDetailsService;
    }

    @PostMapping
    public ResponseEntity<String> createCourseAssessmentDetails(@RequestBody CourseAssessmentDetails courseAssessmentDetails) {
        CourseAssessmentDetails newCourseAssessmentDetails = courseAssessmentDetailsService.createCourseAssessmentDetails(courseAssessmentDetails);
        return new ResponseEntity<>("new item created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseAssessmentDetails>> getCourseAssessmentDetailsAll() {
        List<CourseAssessmentDetails> courseAssessmentDetailsList = courseAssessmentDetailsService.getCourseAssessmentDetailsAll();
        return new ResponseEntity<>(courseAssessmentDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseAssessmentDetails> getCourseAssessmentDetails(@PathVariable("id") Long id) {
        CourseAssessmentDetails courseAssessmentDetails = courseAssessmentDetailsService.getCourseAssessmentDetails(id);
        if (courseAssessmentDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseAssessmentDetails, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourseAssessmentDetails(@PathVariable("id") Long id,
                                                                                 @RequestBody CourseAssessmentDetails courseAssessmentDetails) {
        CourseAssessmentDetails updatedCourseAssessmentDetails =
                courseAssessmentDetailsService.editCourseAssessmentDetails(id, courseAssessmentDetails);
        if (updatedCourseAssessmentDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(("item " + id + " updated"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseAssessmentDetails(@PathVariable("id") Long id) {
        courseAssessmentDetailsService.deleteCourseAssessmentDetails(id);
        return new ResponseEntity<>(("item " + id + " deleted"), HttpStatus.OK);
    }

    @PatchMapping("/courseAssessment")
    public ResponseEntity<CourseAssessmentDetails> assignCourseAssessment(@RequestParam("id") Long id,
                                                    @RequestParam("courseAssessment_id") Long courseAssessment_id) {
        courseAssessmentDetailsService.assignCourseAssessment(id, courseAssessment_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/Student")
    public ResponseEntity<CourseAssessmentDetails> assignStudent(@RequestParam("id") Long id,
                                                    @RequestParam("student_id") Long student_id) {
        courseAssessmentDetailsService.assignStudent(id, student_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/Professor")
    public ResponseEntity<CourseAssessmentDetails> assignProfessor(@RequestParam("id") Long id,
                                                    @RequestParam("professor_id") Long professor_id) {
        courseAssessmentDetailsService.assignProfessor(id, professor_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
