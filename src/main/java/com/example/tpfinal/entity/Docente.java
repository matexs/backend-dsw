package com.example.tpfinal.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docente_id;
    
    private Long legajo;
    
    private String nombre;
  
    // getters y setters
    
    public Long getId() {
        return docente_id;
    }

    public void setId(Long docente_id) {
        this.docente_id = docente_id;
    }
    public Long getLegajo() {
        return legajo;
    }

    public void setLegajo(Long legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
