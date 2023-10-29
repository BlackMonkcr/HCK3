package com.example.hck3.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "periodo")
@Getter
@Setter
@NoArgsConstructor
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @JsonIgnore
    @OneToMany(mappedBy = "periodo")
    private Set<CourseAssessment> courseAssessments;

    public Periodo(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
