package com.example.DavidSisalimaM5A.controller;

import com.example.DavidSisalimaM5A.entity.Curso;
import com.example.DavidSisalimaM5A.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    ICursoService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarProfesor() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Curso> crearProfesor(@RequestBody Curso p) {
        return new ResponseEntity<>(personaService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarProfesor(@PathVariable Long id, @RequestBody Curso p) {
        Curso personaENcontrada = personaService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setNivel(p.getNivel());
                personaENcontrada.setDescripcion(p.getDescripcion());
                return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminarProfesor(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
