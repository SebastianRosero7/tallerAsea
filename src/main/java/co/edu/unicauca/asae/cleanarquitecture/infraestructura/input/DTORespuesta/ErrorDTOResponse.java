package co.edu.unicauca.asae.cleanarquitecture.infraestructura.input.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * DTO simple para respuestas de error en la API.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTOResponse {

    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}

