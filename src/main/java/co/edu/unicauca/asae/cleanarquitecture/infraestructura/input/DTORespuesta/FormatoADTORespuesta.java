package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FormatoPPDTORespuesta.class, name = "PP"),
    @JsonSubTypes.Type(value = FormatoATIDTORespuesta.class, name = "TI")
})
public class FormatoADTORespuesta {

    private Long idFormatoA;
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String estado;
}
