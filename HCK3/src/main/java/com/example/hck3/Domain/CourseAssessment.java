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
@Table(name = "course_assessment")
@Getter
@Setter
@NoArgsConstructor
public class CourseAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "periodo_id", referencedColumnName = "id")
    private Periodo periodo;

    private String tipoNota;

    private String numNota;

    private String nomenclatura;

    @JsonIgnore
    @OneToMany(mappedBy = "courseAssessment")
    private Set<CourseAssessmentDetails> coursesAssessmentDetails;

    public CourseAssessment(String title, Course course, Periodo periodo,
                            String tipoNota, String numNota, String nomenclatura) {
        this.title = title;
        this.course = course;
        this.periodo = periodo;
        this.tipoNota = tipoNota;
        this.numNota = numNota;
        this.nomenclatura = nomenclatura;
    }
}
