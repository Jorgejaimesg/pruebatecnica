package com.pruebatecnica.pruebatecnica.infrastructure.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.pruebatecnica.application.IProductoService;
import com.pruebatecnica.pruebatecnica.domain.entities.Producto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<Producto> getAll() { return productoService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/categoria/{id}")
    public List<Producto> list(@PathVariable Long id){
        return productoService.findAllByCategoriaId(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Producto producto) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            producto.setId(id);
            return ResponseEntity.ok(productoService.update(id, producto));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            productoService.delete(id);
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
