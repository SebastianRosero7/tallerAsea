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
    @NotBlank
    private String cartaAceptacion;
    @NotBlank
    private String asesor;

}
