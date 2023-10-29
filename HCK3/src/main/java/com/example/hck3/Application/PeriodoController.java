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
@RequestMapping("/periodo")
public class PeriodoController {
    private final PeriodoServices periodoServices;

    @Autowired
    public PeriodoController(PeriodoServices periodoServices) {
        this.periodoServices = periodoServices;
    }

    @PostMapping
    public ResponseEntity<Periodo> createPeriodo(@RequestBody Periodo periodo) {
        Periodo newPeriodo = periodoServices.createPeriodo(periodo);
        return new ResponseEntity<>(newPeriodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Periodo>> getPeriodoAll() {
        List<Periodo> periodoList = periodoServices.getPeriodoAll();
        return new ResponseEntity<>(periodoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Periodo> getPeriodo(@PathVariable("id") Long id) {
        Periodo periodo = periodoServices.getPeriodo(id);
        if (periodo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(periodo, HttpStatus.OK);
    }
}
