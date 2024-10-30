package com.example.tpfinal.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.tpfinal.entity.Alumno;
import com.example.tpfinal.repository.AlumnoRepository;

import java.util.Optional;

@Service
public class AlumnoServiceimp {

    @Autowired
    private AlumnoRepository repository;

    public List<Alumno> findAll() {
        return repository.findAll();
    }

   
    public Optional<Alumno> findById(Long id) {
        return repository.findById(id);
    }

  
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

  
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
