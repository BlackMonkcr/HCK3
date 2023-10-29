package com.example.hck3;
import jakarta.persistence.*;

@Entity
@Table(name = "CourseType")
public class CourseType {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    

    public CourseType(){}
    public CourseType(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
