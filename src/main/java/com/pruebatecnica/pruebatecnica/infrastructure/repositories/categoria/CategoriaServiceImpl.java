package com.pruebatecnica.pruebatecnica.infrastructure.repositories.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.pruebatecnica.application.ICategoriaService;
import com.pruebatecnica.pruebatecnica.domain.entities.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();    
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    
    }

    @Override
    public Optional<Categoria> delete(Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            categoriaRepository.delete(categoriaOptional.get());
        }
        return categoriaOptional;

    }

}
