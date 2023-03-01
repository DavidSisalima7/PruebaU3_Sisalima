package com.example.DavidSisalimaM5A.controller;

import com.example.DavidSisalimaM5A.entity.Depto;
import com.example.DavidSisalimaM5A.service.IDeptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/depto")
public class DeptoController {

    @Autowired
    IDeptoService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Depto>> listarProfesor() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Depto> crearProfesor(@RequestBody Depto p) {
        return new ResponseEntity<>(personaService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Depto> actualizarProfesor(@PathVariable Long id, @RequestBody Depto p) {
        Depto personaENcontrada = personaService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setDirector(p.getDirector());
                personaENcontrada.setDireccion(p.getDireccion());
                personaENcontrada.setDescripcion(p.getDescripcion());
                return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminarProfesor(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
