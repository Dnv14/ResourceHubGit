package com.example.resourcehub.services;

import com.example.resourcehub.models.Recurso;
import com.example.resourcehub.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    @Autowired
    RecursoRepository recursoRepository;

    public List<Recurso> obtenerTodos() {
        return recursoRepository.findAll();
    }

    public Optional<Recurso> obtenerPorId(Long id) {
        return recursoRepository.findById(id);
    }

    public Recurso crearRecurso(Recurso recurso) {
        //agregar validaciones de negocio
        return recursoRepository.save(recurso);
    }

    public Optional<Recurso> actualizarCompleto(Long id, Recurso recursoActualizado) {
        return recursoRepository.findById(id).map(recursoExistente -> {
            //acutalizamos el objeto completo
            recursoExistente.setTitulo(recursoActualizado.getTitulo());
            recursoExistente.setCategoria(recursoActualizado.getCategoria());
            recursoExistente.setTipo(recursoActualizado.getTipo());
            recursoExistente.setUrl(recursoActualizado.getUrl());
            return recursoRepository.save(recursoExistente);
        });
    }


    public Optional<Recurso> actualizarParcial(Long id, Recurso recursoActualizado) {
        return recursoRepository.findById(id).map(recursoExistente -> {

            if (recursoActualizado.getTitulo() != null) {
                recursoExistente.setTitulo(recursoActualizado.getTitulo());
            }

            if (recursoActualizado.getCategoria() != null) {
                recursoExistente.setCategoria(recursoActualizado.getCategoria());
            }

            if (recursoActualizado.getTipo() != null) {
                recursoExistente.setTipo(recursoActualizado.getTipo());
            }

            if (recursoActualizado.getUrl() != null) {
                recursoExistente.setUrl(recursoActualizado.getUrl());
            }

            return recursoRepository.save(recursoExistente);
        });
    }

    public boolean eliminarRecurso(Long id) {
        return recursoRepository.deleteById(id);
    }

}
