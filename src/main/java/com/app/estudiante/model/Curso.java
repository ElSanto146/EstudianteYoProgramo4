package com.app.estudiante.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Curso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    Long id_curso;
    
    String nombre;
    
    String tipoCurso; 
    
    @Temporal(TemporalType.DATE)
    Date fechaFinalizacion;
    
    /*@ManyToOne ver un nuevo
    @JoinColumn(name = "lista_de_temas")
    Tema lista_de_temas;*/
    
    /*@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default        
    List<Tema> listaTemas = new ArrayList<>();
    Se mapea con un atributo llamado curso en la entity Tema.
      Cascade type.ALL para que cualquier movimiento que se haga en Curso también se haga en Tema
      fetch para que no sobrecargue el listado listaTema
      orphanRemoval: Si se borra un Curso se borran los Temas relacionados a ese Curso
      Porque se crea una relación de dependencia   */ 
}
