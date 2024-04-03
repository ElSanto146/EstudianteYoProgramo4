package com.app.estudiante.repository;

import com.app.estudiante.model.Tema;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TemaRepository extends JpaRepository<Tema, Long>{
    
    @Query(value = "SELECT * FROM `tema` WHERE fk_curso=:curso", nativeQuery = true)
    public List<Tema> traerTemasPorCurso(@Param("curso") int curso);
    
}
