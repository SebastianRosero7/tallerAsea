package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion.HistoricoDTOPeticion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTORespuesta {
    private Long idDocente;
    private String nombresDocente;
    private String apellidosDocente;
    private String nombreGrupo;
    private String correo;
    private List<HistoricoDTOPeticion> historicos;
    private List<FormatoADTOPeticion> formatosA;
}
