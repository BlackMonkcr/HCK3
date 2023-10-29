package com.example.hck3;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "CourseAssessmentDetails")
public class CourseAssessmentDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String score; 
    private String section;
    
    @OneToMany
    private List<Student> students;
    
    @OneToMany
    private List<Professor> professors;
    
    @ManyToOne
    @JoinColumn(name = "courseAssessment_id")
    private CourseAssessment courseAssessment;
    
    private String sectionGroup;

    public CourseAssessmentDetails(){}
    public CourseAssessmentDetails(Long id, String score, String section, List<Student> students, List<Professor> professors, CourseAssessment courseAssessment, String sectionGroup) {
        this.id = id;
        this.score = score;
        this.section = section;
        this.students = students;
        this.professors = professors;
        this.courseAssessment = courseAssessment;
        this.sectionGroup = sectionGroup;
    }

    // Getters y Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public CourseAssessment getCourseAssessment() {
        return courseAssessment;
    }

    public void setCourseAssessment(CourseAssessment courseAssessment) {
        this.courseAssessment = courseAssessment;
    }

    public String getSectionGroup() {
        return sectionGroup;
    }

    public void setSectionGroup(String sectionGroup) {
        this.sectionGroup = sectionGroup;
    }
}

