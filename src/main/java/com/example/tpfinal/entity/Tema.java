package com.example.tpfinal.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tema_id;
    
    private String nombre;

    private String descripcion;
    
    @OneToMany(mappedBy = "tema")
    private List<Curso> cursos;

    // getters y setters
    public Long getId() {
        return tema_id;
    }

    public void setId(Long tema_id) {
        this.tema_id = tema_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
