package com.example.tpfinal.entity;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alumno_id;
    
    private String nombre;
    
   
    @Column(name="fecha_nac")
    private LocalDate fechaNac;
    
  
    // getters y setters
    public Long getId() {
        return alumno_id;
    }
    
    public void setId(Long alumno_id) {
        this.alumno_id = alumno_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

}
