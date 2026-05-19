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

    @NotBlank(message = "la observacion no puede estar vacia")
    private String observacion;
    @NotNull(message = "debe existir un formato")
    private Long idFormato;
    @NotEmpty(message = "debe relacionar los docentes")
    private List<Long> idDocentes;

    @NotBlank
    private String nombreCordinador;
}
