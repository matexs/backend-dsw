package com.example.tpfinal.service;
import java.time.LocalDate;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.tpfinal.entity.Curso;
import com.example.tpfinal.entity.Docente;
import com.example.tpfinal.repository.CursoRepository;
import com.example.tpfinal.repository.DocenteRepository;

import java.util.Optional;

@Service
public class CursoServiceimp {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private DocenteRepository docenteRepository;
    
    public List<Curso> findAll() {
        return repository.findAll();
    }

    
    public Optional<Curso> findById(Long id) {
        return repository.findById(id);
    }

    
    public Curso save(Curso curso) {
        return repository.save(curso);
    }

   
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    
    public List<Curso> obtenerCursosPorFechaFin(LocalDate fecha){
    	return repository.findByFechaFin(fecha);
    }
    
    
    public List<Curso> obtenerCursoVigentePorDocente(Long docenteId) {
    	Docente docente = docenteRepository.findById(docenteId)
    			.orElseThrow(()-> new RuntimeException("Docente no encontrado"));
    	LocalDate hoy = LocalDate.now();
    	return repository.findByDocenteAndFechaInicioBeforeAndFechaFinAfter(docente,hoy,hoy);}



}