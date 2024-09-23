package com.app.estudiante.controller;

import com.app.estudiante.model.Curso;
import com.app.estudiante.service.ICursoService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos/")//Indica el comienzo de todos los endpoint y evitamos escribir /cursos/ al inicio de cada indpoint
public class CursoController {
    
    @Autowired
    private ICursoService interCurso;
    
    /*@PostMapping("crear")
    public String crearCurso(@RequestBody Curso cur){
        
        interCurso.crearCurso(cur);
        
        return "El curso fué creado exiosamente";
    }*/
    
    
    //Post usando ResponseEntity
    @PostMapping("crear")
    public ResponseEntity<?> crearCurso(@RequestBody Curso cur) throws URISyntaxException{
        interCurso.crearCurso(cur);
        
       //return ResponseEntity.created(new URI("/cursos/crear")).build(); 
       return ResponseEntity.status(504).build();
       //return ResponseEntity.accepted().build();
       //return ResponseEntity.badRequest().build();
       
    }
    
    
    
    @GetMapping("curso/traerTodos")
    public List<Curso> traerCursos(){
        return interCurso.traerCursos();
    }
    
    @PutMapping("editar/{id}")
    public Curso editCurso (@PathVariable Long id,
                            @RequestParam("nombre") String nuevoNombre,
                            @RequestParam("tipoCurso") String nuevoTipoCurso,
                            @RequestParam("fechaFinalizacion") Date nuevaFechaFinalizacion){
        
        Curso cur = interCurso.findCurso(id);
        
        cur.setNombre(nuevoNombre);
        cur.setTipoCurso(nuevoTipoCurso);
        cur.setFechaFinalizacion(nuevaFechaFinalizacion);
        
        interCurso.crearCurso(cur);
        
        return cur;
    }
    
    //Otra manera de hacer el editado. No funciona bien, es mejor el anterior
     @PutMapping("editar2/{id}")
     public void ediarCurso2(@RequestBody Curso curso){
         interCurso.editarCurso(curso);
     }
    
    
     @GetMapping("java")
    public List<Curso> cursosJava(){
        return interCurso.cursosJava();
    }
    
}
