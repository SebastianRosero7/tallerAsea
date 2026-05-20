package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoDTORespuesta {
    private int idHistorico;
    private int activo;
    private String fechaInicio;
    private String fechaFin;
    private RolDTORespuesta objRol;
    private Long objDocente;
}
