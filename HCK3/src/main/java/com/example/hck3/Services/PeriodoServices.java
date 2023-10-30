package com.example.hck3.Services;

import com.example.hck3.Domain.*;
import com.example.hck3.Infrastructure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoServices {
    private final PeriodoRepository periodoRepository;

    @Autowired
    public PeriodoServices(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    public Periodo createPeriodo(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    public List<Periodo> getPeriodoAll() {
        return periodoRepository.findAll();
    }

    public Periodo getPeriodo(Long id) {
        return periodoRepository.findById(id).orElse(null);
    }
}
