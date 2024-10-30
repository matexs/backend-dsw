package com.example.tpfinal.controller;


import com.example.tpfinal.service.TemaServiceimp;

import com.example.tpfinal.entity.Tema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/temas")
public class TemaController{
	
	@Autowired
	private TemaServiceimp temaService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Tema> getAllTema(){
			return temaService.findAll();
		}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getTemaById(@PathVariable Long id){
		Optional<Tema> tema = temaService.findById(id);
		if (tema.isPresent()) {
            return ResponseEntity.ok(tema.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
		
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
    public Tema createTema(@RequestBody Tema tema) {
        return temaService.save(tema);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
    public ResponseEntity<Tema> updateTema(@PathVariable Long id, @RequestBody Tema temaDetails) {
        Optional<Tema> tema = temaService.findById(id);
        if (tema.isPresent()) {
            Tema updatedTema = tema.get();
            updatedTema.setNombre(temaDetails.getNombre());
            updatedTema.setDescripcion(temaDetails.getDescripcion());
            return ResponseEntity.ok(temaService.save(updatedTema));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	   @CrossOrigin(origins = "http://localhost:4200")
	   @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTema(@PathVariable Long id) {
	        Optional<Tema> tema = temaService.findById(id);
	        if (tema.isPresent()) {
	            temaService.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	   
}
