package com.example.tpfinal.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long curso_id;
    
    @ManyToOne
    @JoinColumn(name="docente_id")
    private Docente docente;
    
    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;
    
    @Column(name="fecha_inicio")
    private LocalDate fechaInicio;
    
    @Column(name="fecha_fin")
    private LocalDate fechaFin;
    
    private BigDecimal precio;
    
    @ManyToMany
    @JoinTable(
    	name= "curso_alumno",
    	joinColumns = @JoinColumn(name="curso_id"),
    	inverseJoinColumns= @JoinColumn(name="alumno_id")
    		)
    
    private List<Alumno> alumnos= new ArrayList<>();
  
    
    // getters y setters
    public Long getid() {
        return curso_id;
    }

    public void setId(Long curso_id) {
        this.curso_id = curso_id;
    }


    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    public List<Alumno> getAlumnos(){
    	return alumnos;
    }
    
    public void setAlumnos(List<Alumno> alumnos) {
    	this.alumnos = alumnos;
    }
    
    public void addAlumno(Alumno alumno) {
    	alumnos.add(alumno);
    	
    }
    
    public void removeAlumno(Alumno alumno) {
    	alumnos.remove(alumno);
    
    }
    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}


