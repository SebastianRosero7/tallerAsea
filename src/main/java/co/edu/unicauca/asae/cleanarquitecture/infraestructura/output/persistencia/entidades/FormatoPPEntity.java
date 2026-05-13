package co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "formatos_pp_a")
@PrimaryKeyJoinColumn(name = "idFormatoPP")
@Data
public class FormatoPPEntity extends FormatoAEntity{

    @Column(name = "nombre_asesor",length = 100)
    private String nombreAsesor;

    @Column(name = "nombre_estudiante1",length = 100)
    private String nombreEstudiante1;
    
    @Column(name = "ruta_carta_aceptacion",length = 255)
    private String ruta_carta_aceptacion;
}
