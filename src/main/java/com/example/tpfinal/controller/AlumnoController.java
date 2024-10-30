package com.example.tpfinal.controller;

import com.example.tpfinal.service.AlumnoServiceimp;

import com.example.tpfinal.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
	
	@Autowired
	private AlumnoServiceimp alumnoService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Alumno> getAllAlumno(){
			return alumnoService.findAll();
		}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id){
		Optional<Alumno> alumno = alumnoService.findById(id);
		if (alumno.isPresent()) {
            return ResponseEntity.ok(alumno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
		
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
        Optional <Alumno> alumno = alumnoService.findById(id);
        if (alumno.isPresent()) {
            Alumno updatedAlumno = alumno.get();
            updatedAlumno.setNombre(alumnoDetails.getNombre());
            updatedAlumno.setFechaNac(alumnoDetails.getFechaNac());
           
            return ResponseEntity.ok(alumnoService.save(updatedAlumno));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
		
		@CrossOrigin(origins = "http://localhost:4200")
	   @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
	        Optional<Alumno> alumno = alumnoService.findById(id);
	        if (alumno.isPresent()) {
	            alumnoService.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	  
	
}
