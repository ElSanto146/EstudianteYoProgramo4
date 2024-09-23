package com.app.estudiante.service;

import com.app.estudiante.model.Curso;
import java.util.List;


public interface ICursoService {
    
    public void crearCurso(Curso cur);
    
    public List<Curso> traerCursos();
    
    public Curso findCurso(Long id);
    
    public List<Curso> cursosJava();
    
    public void editarCurso(Curso curso);
}
