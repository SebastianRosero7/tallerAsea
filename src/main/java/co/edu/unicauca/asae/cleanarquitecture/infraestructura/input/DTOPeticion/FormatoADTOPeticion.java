package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FormatoPPDTOPeticion.class, name = "PP"),
    @JsonSubTypes.Type(value = FormatoTIDTOPeticion.class, name = "TI")
})
public class FormatoADTOPeticion {
    
    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;
    @NotBlank(message = "El objetivo general es obligatorio")
    private String objetivoGeneral;
    @NotBlank(message = "Los objetivos especificos son obligatorio")
    @Size(min = 10, message = "Minimo 3 objetivos especificos")
    private String objetivosEspecificos;
    @NotNull
    private Long idDocente;

}
