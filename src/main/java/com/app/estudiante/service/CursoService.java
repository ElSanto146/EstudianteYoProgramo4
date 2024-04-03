package com.app.estudiante.service;

import com.app.estudiante.model.Curso;
import com.app.estudiante.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private CursoRepository cursoRepo;

    @Override
    public void crearCurso(Curso cur) {
        cursoRepo.save(cur);
    }

    @Override
    public List<Curso> traerCursos() {
        List<Curso> listaCurso = cursoRepo.findAll();
        return listaCurso;
    }

    @Override
    public Curso findCurso(Long id) {
        Curso cur = cursoRepo.findById(id).orElse(null);
        return cur;
    }

    @Override
    public List<Curso> cursosJava() {
        List<Curso> listaCurso1 = cursoRepo.cursosJava();
        return listaCurso1;
    }
    
}
