package com.app.estudiante.service;

import com.app.estudiante.model.Tema;
import com.app.estudiante.repository.TemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TemaService implements ITemaService{
    
    @Autowired
    private TemaRepository temaRepo;

    @Override
    public void crearTema(Tema tem) {
        temaRepo.save(tem);
    }

    @Override
    public List<Tema> traerTemasPorCurso(int curso) {
        List<Tema> listaTema = temaRepo.traerTemasPorCurso(curso);
        return listaTema;
    }

    @Override
    public Tema findTema(Long id) {
        return temaRepo.findById(id).orElse(null);
    }
    
}
