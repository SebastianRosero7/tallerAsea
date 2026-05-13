package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTORespuesta;

import java.time.LocalDate;

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
    @JsonSubTypes.Type(value = FormatoTIDTORespuesta.class, name = "TI")
})
public class FormatoADTORespuesta {

    private Integer id;
    private String titulo;
    private String director;
    private String estudiante1;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String estado;
}
