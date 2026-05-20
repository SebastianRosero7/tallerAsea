package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoDTOPeticion {
    private int idHistorico;
    private int activo;
    private String fechaInicio;
    private String fechaFin;
    private Long objRol;
    private Long objDocente;
}
