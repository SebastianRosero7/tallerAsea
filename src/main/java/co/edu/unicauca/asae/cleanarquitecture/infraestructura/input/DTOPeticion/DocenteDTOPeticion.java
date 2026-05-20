package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTOPeticion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTOPeticion {

    @NotBlank(message = "{error.docente.name.empty}")
    private String nombresDocente;

    @NotBlank(message = "{error.docente.last_name.empty}")
    private String apellidosDocente;

    @NotBlank(message = "{error.docente.grupo.empty}")
    private String nombreGrupo;

    @NotBlank(message = "{error.docente.email.empty}")
    @Email(message = "{error.docente.email.invalid}")
    private String correo;

}
