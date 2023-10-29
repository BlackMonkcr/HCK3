package com.example.hck3;
import jakarta.persistence.*;

@Entity
@Table(name = "Profesor")
public class Professor {
    
    private String name;
    private String lastname;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String fullName;

    public Professor(){}
    public Professor(Long id, String name, String lastname, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.fullName = name + " " + lastname; 
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
        updateFullName(); 
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
        updateFullName(); 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    private void updateFullName() {
        this.fullName = name + " " + lastname;
    }
}

