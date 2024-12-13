package com.pruebatecnica.pruebatecnica.infrastructure.repositories.producto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pruebatecnica.pruebatecnica.domain.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :categoriaId")
    List<Producto> findAllByCategoriaId(@Param("categoriaId") Long categoriaId);
}
