package com.pruebatecnica.pruebatecnica.application;

import java.util.List;
import java.util.Optional;

import com.pruebatecnica.pruebatecnica.domain.entities.Categoria;

public interface ICategoriaService {
    Categoria save(Categoria categoria);
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Optional<Categoria> delete(Long id);
}
