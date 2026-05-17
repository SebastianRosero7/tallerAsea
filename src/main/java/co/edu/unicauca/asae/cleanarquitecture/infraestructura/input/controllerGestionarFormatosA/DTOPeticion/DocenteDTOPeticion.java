package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.controllerGestionarFormatosA.DTOPeticion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTOPeticion {

    @NotBlank(message = "El nombre del docente es obligatorio")
    private String nombresDocente;

    @NotBlank(message = "El apellido del docente es obligatorio")
    private String apellidosDocente;

    private String nombreGrupo;

    @NotBlank(message = "El correo del docente es obligatorio")
    @Email(message = "El correo del docente debe ser una dirección de correo electrónico válida")
    private String correo;

}
