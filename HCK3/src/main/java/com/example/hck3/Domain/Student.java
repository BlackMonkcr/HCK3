package com.example.hck3.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String code;

    @JsonManagedReference
    @OneToMany(mappedBy = "student")
    private Set<CourseAssessmentDetails> coursesAssessmentDetails;

    public Student(String name, String email, String code) {
        this.name = name;
        this.email = email;
        this.code = code;
    }
}
