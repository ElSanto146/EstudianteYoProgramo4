package com.app.estudiante.repository;

import com.app.estudiante.model.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CursoRepository extends JpaRepository<Curso, Long>{
    
    @Query(value = "SELECT * FROM `curso` WHERE nombre LIKE '%Java%'", nativeQuery = true)
    public List<Curso> cursosJava();
    
}
