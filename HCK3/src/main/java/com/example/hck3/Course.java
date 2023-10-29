package com.example.hck3;

import jakarta.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

    private String name;
    private Integer credits;
    private Long id;
    private CourseType courseType;
    private CourseContent courseContent;

    public Course() {}

    public Course(Long id, String name, Integer credits, CourseType courseType, CourseContent courseContent) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.courseType = courseType;
        this.courseContent = courseContent;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public CourseContent getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(CourseContent courseContent) {
        this.courseContent = courseContent;
    }
}
