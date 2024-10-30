package com.example.tpfinal.repository;



import com.example.tpfinal.entity.Curso;
import com.example.tpfinal.entity.Docente;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	List<Curso> findByFechaFin(LocalDate fecha);
	
	List<Curso> findByDocenteAndFechaInicioBeforeAndFechaFinAfter(Docente docente, LocalDate fechaInicio, LocalDate fechaFin);
	

	
}