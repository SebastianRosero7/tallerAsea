package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObservacionDTOPeticion {

    @NotBlank(message = "{error.observacion.observacion.empty}")
    private String observacion;
    @NotNull(message = "{error.observacion.formato.null}")
    private Long idFormato;
    @NotEmpty(message = "{error.observacion.docente.empy}")
    private List<Long> idDocentes;

    @NotBlank(message = "{error.observacion.coordinador.empty}")
    private String nombreCordinador;
}
