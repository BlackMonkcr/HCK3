package com.example.hck3.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "course_type")
@Getter
@Setter
@NoArgsConstructor
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "courseType")
    private Set<Course> courses;

    public CourseType(String name) {
        this.name = name;
    }
}
