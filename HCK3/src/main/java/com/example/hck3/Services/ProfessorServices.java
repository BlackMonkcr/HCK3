package com.example.hck3.Services;

import com.example.hck3.Domain.*;
import com.example.hck3.Infrastructure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServices {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServices(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> getProfessorAll() {
        return professorRepository.findAll();
    }

    public Professor getProfessor(Long id) {
        return professorRepository.findById(id).orElse(null);
    }
}
