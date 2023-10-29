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
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int credits;

    private String code;

    private String HRGroup;

    private int cycle;

    @ManyToOne
    @JoinColumn(name = "course_type_id", referencedColumnName = "id")
    private CourseType courseType;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<CourseAssessment> courseAssessments;

    private String VRGroup;

    public Course(String name, int credits, String code, String HRGroup, int cycle, String VRGroup) {
        this.name = name;
        this.credits = credits;
        this.code = code;
        this.HRGroup = HRGroup;
        this.cycle = cycle;
        this.VRGroup = VRGroup;
    }
}
