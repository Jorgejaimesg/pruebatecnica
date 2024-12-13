package com.pruebatecnica.pruebatecnica.infrastructure.repositories.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.pruebatecnica.application.IProductoService;
import com.pruebatecnica.pruebatecnica.domain.entities.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

    
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Transactional
    @Override
    public Producto save (Producto producto) {
        return productoRepository.save(producto);
    }

    @Transactional
    @Override
    public Optional<Producto> update(Long id, Producto producto) {
        Optional<Producto> productoOld = productoRepository.findById(id);
        if(productoOld.isPresent()){
            Producto productoDb = productoOld.orElseThrow();
            productoDb.setNombre(producto.getNombre());
            productoDb.setDescripcion(producto.getDescripcion());
            productoDb.setPrecio(producto.getPrecio());
            productoDb.setCategoria(producto.getCategoria());
            return Optional.of(productoRepository.save(productoDb));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Producto> delete(Long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        productoOptional.ifPresent(productoDb -> {
            productoRepository.delete(productoDb);
        });
        return productoOptional;
    }
    @Override
    public List<Producto> findAllByCategoriaId(Long id) {
        return (List<Producto>) productoRepository.findAllByCategoriaId(id);
    }

}
