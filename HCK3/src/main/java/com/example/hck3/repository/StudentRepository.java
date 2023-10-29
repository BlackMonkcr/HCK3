package com.example.hck3.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hck3.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
