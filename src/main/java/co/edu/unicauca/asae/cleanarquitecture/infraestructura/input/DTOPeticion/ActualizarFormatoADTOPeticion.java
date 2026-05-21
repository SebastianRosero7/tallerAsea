package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarFormatoADTOPeticion {
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
}
