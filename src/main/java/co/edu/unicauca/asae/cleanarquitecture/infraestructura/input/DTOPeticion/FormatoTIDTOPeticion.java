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

    @NotBlank(message = "El estudiante uno es obligatorio")
    private String nombreEstudiante1;
    @NotBlank(message = "El estudiante dos es obligatorio")
    private String nombreEstudiante2;

}
