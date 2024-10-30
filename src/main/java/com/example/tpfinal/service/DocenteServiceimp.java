package com.example.tpfinal.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.tpfinal.entity.Docente;
import com.example.tpfinal.repository.DocenteRepository;

import java.util.Optional;

@Service
public class DocenteServiceimp{

    @Autowired
    private DocenteRepository repository;

   
    public List<Docente> findAll() {
        return repository.findAll();
    }

   
    public Optional<Docente> findById(Long id) {
        return repository.findById(id);
    }

   
    public Docente save(Docente docente) {
        return repository.save(docente);
    }

   
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
