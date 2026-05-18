package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FormatoTIDTOPeticion extends FormatoADTOPeticion {

    private String estudiante2;

}
