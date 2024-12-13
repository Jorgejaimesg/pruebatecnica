package com.pruebatecnica.pruebatecnica.application;

import java.util.List;
import java.util.Optional;

import com.pruebatecnica.pruebatecnica.domain.entities.Producto;

public interface IProductoService {
    Producto save(Producto producto);
    Optional<Producto> findById(Long id);
    List<Producto> findAll();
    List<Producto> findAllByCategoriaId(Long id);
    Optional<Producto> update(Long id, Producto Producto);
    Optional<Producto> delete(Long id);
}
