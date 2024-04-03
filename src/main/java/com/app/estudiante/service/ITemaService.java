package com.app.estudiante.service;

import com.app.estudiante.model.Tema;
import java.util.List;
import org.springframework.data.repository.query.Param;


public interface ITemaService {
    
    public void crearTema(Tema tem);
    
    public List<Tema> traerTemasPorCurso(@Param("curso") int curso);
    
    public Tema findTema(Long id);
    
}
