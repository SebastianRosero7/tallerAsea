package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class GenericResponse {
    private String message;
    private Collection<Object> data;
}
