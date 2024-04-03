package com.app.estudiante.controller;

import com.app.estudiante.model.Tema;
import com.app.estudiante.service.ITemaService;
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
public class TemaController {
    
    @Autowired
    private ITemaService interTema;
    
    
    @PostMapping("/temas/crear")
    public String crearTema (@RequestBody Tema tem){
        interTema.crearTema(tem);
        return"Tema creado exitosamente";
    }
    
    @GetMapping("/temas/porCurso/{curso}")
    public List<Tema> traerTemasPorCurso(@PathVariable int curso){
        return interTema.traerTemasPorCurso(curso);
    }
    
    @PutMapping("/temas/edit/{id}")
    public Tema editTema (@PathVariable Long id,
                          @RequestParam("nombre") String nuevoNombre,
                          @RequestParam("descripcion") String nuevaDescripcion){
        
        Tema tem = interTema.findTema(id);
        
        tem.setNombre(nuevoNombre);
        tem.setDescripcion(nuevaDescripcion);
        
        interTema.crearTema(tem);
        
        return tem;
    }
    
}
