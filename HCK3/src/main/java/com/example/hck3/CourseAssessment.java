package com.example.hck3;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "CourseAssessment")
public class CourseAssessment {

    private Course course;
    private Periodo periodo;
    private String title;
    private Long id;
    private String tipoNota;
    private String numNota;
    private String nomenclatura;

    public CourseAssessment() {}

    public CourseAssessment(Course course, Periodo periodo, String title, Long id, String tipoNota, String numNota, String nomenclatura) {
        this.course = course;
        this.periodo = periodo;
        this.title = title;
        this.id = id;
        this.tipoNota = tipoNota;
        this.numNota = numNota;
        this.nomenclatura = nomenclatura;
    }

    // Getters y Setters

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public String getNumNota() {
        return numNota;
    }

    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }
}
