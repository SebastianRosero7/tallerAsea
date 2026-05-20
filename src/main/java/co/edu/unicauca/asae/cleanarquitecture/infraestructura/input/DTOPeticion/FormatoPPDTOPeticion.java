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
public class FormatoPPDTOPeticion extends FormatoADTOPeticion {
    @NotBlank(message = "{error.formato.path.null}")
    private String ruta_carta_aceptacion;
    @NotBlank(message = "{error.formato.asesor.null}")
    private String nombreAsesor;
    @NotBlank(message = "El estudiante uno es obligatorio")
    private String nombreEstudiante1;
}
