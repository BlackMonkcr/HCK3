package com.example.hck3.Application;

import com.example.hck3.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hck3.Domain.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorServices professorServices;

    @Autowired
    public ProfessorController(ProfessorServices professorServices) {
        this.professorServices = professorServices;
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor newProfessor = professorServices.createProfessor(professor);
        return new ResponseEntity<>(newProfessor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getProfessorAll() {
        List<Professor> professorList = professorServices.getProfessorAll();
        return new ResponseEntity<>(professorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessor(@PathVariable("id") Long id) {
        Professor professor = professorServices.getProfessor(id);
        if (professor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }
}
