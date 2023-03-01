package com.example.DavidSisalimaM5A.controller;

import com.example.DavidSisalimaM5A.entity.Profesor;
import com.example.DavidSisalimaM5A.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    IProfesorService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarProfesor() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor p) {
        return new ResponseEntity<>(personaService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor p) {
        Profesor personaENcontrada = personaService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setTelefono(p.getTelefono());
                personaENcontrada.setDireccion(p.getDireccion());
                return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
