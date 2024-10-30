package com.example.tpfinal.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.tpfinal.entity.Tema;
import com.example.tpfinal.repository.TemaRepository;

import java.util.Optional;

@Service
public class TemaServiceimp {

    @Autowired
    private TemaRepository repository;

    public List<Tema> findAll() {
        return repository.findAll();
    }

    public Optional<Tema> findById(Long id) {
        return repository.findById(id);
    }

    public Tema save(Tema tema) {
        return repository.save(tema);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

