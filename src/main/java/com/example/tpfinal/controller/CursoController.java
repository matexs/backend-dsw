package com.example.tpfinal.controller;

import com.example.tpfinal.service.AlumnoServiceimp;
import com.example.tpfinal.service.CursoServiceimp;
import com.example.tpfinal.entity.Alumno;
import com.example.tpfinal.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	
	@Autowired
	private CursoServiceimp cursoService;
	
	@Autowired
	private AlumnoServiceimp alumnoService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Curso> getAllCurso(){
			return cursoService.findAll();
		}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<Curso> getCursoById(@PathVariable Long id){
		Optional<Curso> curso = cursoService.findById(id);
		if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }
        

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            Curso updatedCurso = curso.get();
           updatedCurso.setTema(cursoDetails.getTema());
            updatedCurso.setFechaInicio(cursoDetails.getFechaInicio());
            updatedCurso.setFechaFin(cursoDetails.getFechaFin());
           updatedCurso.setDocente(cursoDetails.getDocente());
           updatedCurso.setPrecio(cursoDetails.getPrecio());
           updatedCurso.setAlumnos(cursoDetails.getAlumnos());
            
            
            return ResponseEntity.ok(cursoService.save(updatedCurso));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
		@CrossOrigin(origins = "http://localhost:4200")
	   @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
	        Optional<Curso> curso = cursoService.findById(id);
	        if (curso.isPresent()) {
	            cursoService.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	   

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}/inscripcion/{id_alumno}")
		public ResponseEntity<Curso> inscribirAlumnoACurso(@PathVariable Long id, @PathVariable Long id_alumno) {
    Optional<Curso> cursoOpt = cursoService.findById(id);
    Optional<Alumno> alumnoOpt = alumnoService.findById(id_alumno);

    if (cursoOpt.isPresent() && alumnoOpt.isPresent()) {
        Curso curso = cursoOpt.get();
        Alumno alumno = alumnoOpt.get();

        curso.addAlumno(alumno);  

        return ResponseEntity.ok(cursoService.save(curso));
    } else {
        return ResponseEntity.notFound().build();
    }
}
		@CrossOrigin(origins = "http://localhost:4200")  
		@PutMapping("/{id}/remover-inscripcion/{id_alumno}")
		public ResponseEntity<Curso> removerAlumnoDeCurso(@PathVariable Long id, @PathVariable Long id_alumno) {
    		Optional<Curso> cursoOpt = cursoService.findById(id);
    		Optional<Alumno> alumnoOpt = alumnoService.findById(id_alumno);
    		
    		if (cursoOpt.isPresent()) {
        		Curso curso = cursoOpt.get();
        		curso.removeAlumno(alumnoOpt.get());  

        		return ResponseEntity.ok(cursoService.save(curso));
    		} else {
        	return ResponseEntity.notFound().build();
    		}
}

	    // Endpoint para obtener cursos por fecha de finalización
		@CrossOrigin(origins = "http://localhost:4200")
	    @GetMapping("/fin/{fechaFin}")
	    public ResponseEntity<List<Curso>> getCursosByFechaFin(
	               @PathVariable("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
	           
	           List<Curso> cursos = cursoService.obtenerCursosPorFechaFin(fechaFin);
	           if (cursos.isEmpty()) {
	               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	           }
	           return new ResponseEntity<>(cursos, HttpStatus.OK);
	       }
	   
	   
	   // Endpoint para obtener cursos vigentes de un profesor
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/docente/{docenteId}/curso-vigente")
	   public ResponseEntity<List<Curso>> obtenerCursosVigentes(@PathVariable Long docenteId) {
	   		List<Curso> cursosVigentes = cursoService.obtenerCursoVigentePorDocente(docenteId);
		   return ResponseEntity.ok(cursosVigentes);
	   }
	   
	   
	  
}
