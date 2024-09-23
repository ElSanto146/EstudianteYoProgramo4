package com.app.estudiante.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Tema implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    Long id_tema;
    
    //@Column(name= "name") Así se va a llamar la columna en la BBDD. Si no se especifíca un nombre tomará el nombre del atributo
    String nombre;
    
    String descripcion;
    
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_curso", nullable=false)//nullable para que halla la relación
    Curso curso;
    
}
 