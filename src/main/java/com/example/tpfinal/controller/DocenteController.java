package com.example.tpfinal.controller;


import com.example.tpfinal.service.DocenteServiceimp;

import com.example.tpfinal.entity.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/docentes")
public class DocenteController {
	
	@Autowired
	private DocenteServiceimp docenteService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Docente> getAllDocentes(){
			return docenteService.findAll();
		}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<Docente> getDocenteById(@PathVariable Long id){
		Optional<Docente> docente = docenteService.findById(id);
		if (docente.isPresent()) {
            return ResponseEntity.ok(docente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
		
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Docente createDocente(@RequestBody Docente docente) {
        return docenteService.save(docente);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
    public ResponseEntity<Docente> updateDocente(@PathVariable Long id, @RequestBody Docente docenteDetails) {
        Optional<Docente> docente = docenteService.findById(id);
        if (docente.isPresent()) {
            Docente updatedDocente = docente.get();
            updatedDocente.setNombre(docenteDetails.getNombre());
            updatedDocente.setLegajo(docenteDetails.getLegajo());
            
            return ResponseEntity.ok(docenteService.save(updatedDocente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
		@CrossOrigin(origins = "http://localhost:4200")
	   @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDocente(@PathVariable Long id) {
	        Optional<Docente> docente = docenteService.findById(id);
	        if (docente.isPresent()) {
	            docenteService.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	   
}