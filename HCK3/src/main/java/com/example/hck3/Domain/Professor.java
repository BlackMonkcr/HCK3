package com.example.hck3.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "professor")
@Getter
@Setter
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String fullName;

    @JsonManagedReference
    @OneToMany(mappedBy = "professor")
    private Set<CourseAssessmentDetails> coursesAssessmentDetails;

    public Professor(String name, String lastName, String email, String fullName) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.fullName = fullName;
    }
}
