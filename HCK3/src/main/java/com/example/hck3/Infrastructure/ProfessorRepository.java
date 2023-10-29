package com.example.hck3.Infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hck3.Domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {}
