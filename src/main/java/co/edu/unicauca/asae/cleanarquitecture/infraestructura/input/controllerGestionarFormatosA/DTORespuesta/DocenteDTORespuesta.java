package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta;

import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.FormatoADTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion.HistoricoDTOPeticion;
import co.edu.unicauca.asae.cleanarquitecture.infraestructura.output.persistencia.entidades.DocenteEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
