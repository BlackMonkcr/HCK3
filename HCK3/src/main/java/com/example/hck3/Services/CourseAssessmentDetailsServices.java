package com.example.hck3.Services;

import com.example.hck3.Domain.*;
import com.example.hck3.Infrastructure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAssessmentDetailsServices {
    private final CourseAssessmentDetailsRepository courseAssessmentDetailsRepository;
    private final CourseAssessmentRepository courseAssessmentRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    @Autowired
    public CourseAssessmentDetailsServices(CourseAssessmentDetailsRepository courseAssessmentDetailsRepository,
                                           CourseAssessmentRepository courseAssessmentRepository,
                                           StudentRepository studentRepository,
                                           ProfessorRepository professorRepository) {
        this.courseAssessmentDetailsRepository = courseAssessmentDetailsRepository;
        this.courseAssessmentRepository = courseAssessmentRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    public CourseAssessmentDetails createCourseAssessmentDetails(CourseAssessmentDetails courseAssessmentDetails) {
        return courseAssessmentDetailsRepository.save(courseAssessmentDetails);
    }

    public List<CourseAssessmentDetails> getCourseAssessmentDetailsAll() {
        return courseAssessmentDetailsRepository.findAll();
    }

    public CourseAssessmentDetails getCourseAssessmentDetails(Long id) {
        return courseAssessmentDetailsRepository.findById(id).orElse(null);
    }

    public CourseAssessmentDetails editCourseAssessmentDetails(Long id,
                                                              CourseAssessmentDetails courseAssessmentDetails) {
        Optional<CourseAssessmentDetails> courseAssessmentDetailsOptional = courseAssessmentDetailsRepository
                .findById(id);

        if (courseAssessmentDetailsOptional.isEmpty()) {
            return null;
        } else {
            CourseAssessmentDetails courseAssessmentDetailsUpdate = courseAssessmentDetailsOptional.get();
            courseAssessmentDetailsUpdate.setScore(courseAssessmentDetails.getScore());
            courseAssessmentDetailsUpdate.setSection(courseAssessmentDetails.getSection());
            courseAssessmentDetailsUpdate.setSectionGroup(courseAssessmentDetails.getSectionGroup());
            return courseAssessmentDetailsRepository.save(courseAssessmentDetails);
        }
    }

    public String deleteCourseAssessmentDetails(Long id) {
        Optional<CourseAssessmentDetails> courseAssessmentDetailsOptional = courseAssessmentDetailsRepository
                .findById(id);

        if (courseAssessmentDetailsOptional.isEmpty()) {
            return null;
        } else {
            courseAssessmentDetailsRepository.deleteById(id);
            return "CourseAssessmentDetails with id " + id + " has been deleted!";
        }
    }

    public CourseAssessmentDetails assignCourseAssessment(Long id, Long courseAssessmentId) {
        CourseAssessmentDetails courseAssessmentDetails = courseAssessmentDetailsRepository.findById(id).orElseThrow();
        CourseAssessment courseAssessment = courseAssessmentRepository.findById(courseAssessmentId).orElseThrow();
        courseAssessmentDetails.setCourseAssessment(courseAssessment);
        return courseAssessmentDetailsRepository.save(courseAssessmentDetails);
    }

    public CourseAssessmentDetails assignStudent(Long id, Long studentId) {
        CourseAssessmentDetails courseAssessmentDetails = courseAssessmentDetailsRepository.findById(id).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();
        courseAssessmentDetails.setStudent(student);
        return courseAssessmentDetailsRepository.save(courseAssessmentDetails);
    }

    public CourseAssessmentDetails assignProfessor(Long id, Long professorId) {
        CourseAssessmentDetails courseAssessmentDetails = courseAssessmentDetailsRepository.findById(id).orElseThrow();
        Professor professor = professorRepository.findById(professorId).orElseThrow();
        courseAssessmentDetails.setProfessor(professor);
        return courseAssessmentDetailsRepository.save(courseAssessmentDetails);
    }
}
