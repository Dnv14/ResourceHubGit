package com.example.resourcehub.controllers;

import com.example.resourcehub.models.Recurso;
import com.example.resourcehub.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    RecursoService recursoService;

    //endoint: GET /api/recursos
    @GetMapping
    public List<Recurso> listar() {
        return recursoService.obtenerTodos();
    }

    //endpoint GET /api/recursos/{id}
    @GetMapping("/{id}")
    public Recurso obtenerPorId(@PathVariable Long id) {
        return recursoService.obtenerPorId(id).orElse(null);
    }

    //endpoint: POST /api/recursos
    @PostMapping
    public Recurso crearRecurso(@RequestBody Recurso recurso) {
        return recursoService.crearRecurso(recurso);
    }

    //actualizacion completa
    //endpoint: PUT /api/recursos/{id}
    @PutMapping("/{id}")
    public Recurso actualizarCompleto(@PathVariable Long id, @RequestBody Recurso recurso) {
        return recursoService.actualizarCompleto(id, recurso).orElse(null);
    }

    //actualizacion Parcial
    //endpoint: PATCH /api/recursos/{id}
    @PatchMapping("/{id}")
    public Recurso actualizarParcial(@PathVariable Long id, @RequestBody Recurso recurso) {
        return recursoService.actualizarParcial(id, recurso).orElse(null);
    }

    //endpoint: DELETE /api/recursos/{id}
    @DeleteMapping("/{id}")
    public void eliminarRecurso(@PathVariable Long id) {
        recursoService.eliminarRecurso(id);
    }
}

