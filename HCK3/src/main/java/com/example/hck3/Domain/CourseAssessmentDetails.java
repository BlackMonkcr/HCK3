package com.example.hck3.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_assessment_details")
@Getter
@Setter
@NoArgsConstructor
public class CourseAssessmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String score;

    private String section;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "course_assessment_id", referencedColumnName = "id")
    private CourseAssessment courseAssessment;

    private String sectionGroup;

    public CourseAssessmentDetails(String score, String section,
                                   Professor professor, String sectionGroup) {
        this.score = score;
        this.section = section;
        this.student = student;
        this.professor = professor;
        this.courseAssessment = courseAssessment;
        this.sectionGroup = sectionGroup;
    }
}