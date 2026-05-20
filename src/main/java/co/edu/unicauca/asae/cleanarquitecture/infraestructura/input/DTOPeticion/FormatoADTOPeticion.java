package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion;


import co.edu.unicauca.asae.cleanarquitecture.infraestructura.configuracion.anotacion.ObjetivoValido;
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
    
    @NotBlank(message = "{error.formato.title.empty}")
    private String titulo;
    @NotBlank(message = "{error.formato.objetivo.empty}")
    @ObjetivoValido(message = "{error.formato.objetivo.invalid}")
    private String objetivoGeneral;
    @NotBlank(message = "{error.formato.objetivo_especifico.empty}")
    @Size(min = 3, message = "{error.formato.objetivo_especifico.invalid}")
    @Size(min = 10, message = "{error.formato.objetivo_especifico.min_size}")
    private String objetivosEspecificos;
    @NotNull(message = "{error.formato.docente.null}")
    private Long idDocente;

}
