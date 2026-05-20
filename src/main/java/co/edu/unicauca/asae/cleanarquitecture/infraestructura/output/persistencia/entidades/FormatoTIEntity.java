package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "formatos_ti_a")
@PrimaryKeyJoinColumn(name = "idFormatoTi")
@Getter
@Setter
public class FormatoTIEntity extends FormatoAEntity{

    @Column(name = "nombre_estudiante1",length = 100)
    private String nombreEstudiante1;
    
    @Column(name = "nombre_estudiante2",length = 100)
    private String nombreEstudiante2;
}
