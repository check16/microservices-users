package com.formacionbdi.microservicios.app.usuarios.controllers;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoService.findById(id);
        if (optionalAlumno.isEmpty()) {
            return ResponseEntity.notFound()
                                 .build();
        }
        return ResponseEntity.ok(alumnoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        Alumno alumnoDB = alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(alumnoDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Alumno> optionalAlumno = alumnoService.findById(id);
        if (optionalAlumno.isEmpty()) {
            return ResponseEntity.notFound()
                                 .build();
        }
        Alumno alumnoDB = optionalAlumno.get();
        alumnoDB.setNombre(alumno.getNombre());
        alumnoDB.setApellido(alumno.getApellido());
        alumnoDB.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(alumnoService.save(alumnoDB));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        alumnoService.deleteById(id);
        return ResponseEntity.noContent()
                             .build();
    }
}
