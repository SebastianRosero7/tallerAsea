package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FormatoTIDTOPeticion extends FormatoADTOPeticion {

    @NotBlank(message = "{error.formato.estudiante1.null}")
    private String nombreEstudiante1;
    @NotBlank(message = "{error.formato.estudiante2.null}")
    private String nombreEstudiante2;

}
