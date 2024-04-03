package com.app.estudiante.controller;

import com.app.estudiante.model.Curso;
import com.app.estudiante.service.ICursoService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    
    @Autowired
    private ICursoService interCurso;
    
    @PostMapping("cursos/crear")
    public String crearCurso(@RequestBody Curso cur){
        
        interCurso.crearCurso(cur);
        
        return "El curso fué creado exiosamente";
    }
    
    @GetMapping("curso/traerTodos")
    public List<Curso> traerCursos(){
        return interCurso.traerCursos();
    }
    
    @PutMapping("curso/editar/{id}")
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
    
     @GetMapping("curso/java")
    public List<Curso> cursosJava(){
        return interCurso.cursosJava();
    }
    
}
